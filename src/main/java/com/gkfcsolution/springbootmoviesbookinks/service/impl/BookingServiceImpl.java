package com.gkfcsolution.springbootmoviesbookinks.service.impl;

import com.gkfcsolution.springbootmoviesbookinks.dto.BookingDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.Booking;
import com.gkfcsolution.springbootmoviesbookinks.entity.Show;
import com.gkfcsolution.springbootmoviesbookinks.entity.User;
import com.gkfcsolution.springbootmoviesbookinks.exception.BookingException;
import com.gkfcsolution.springbootmoviesbookinks.exception.ShowException;
import com.gkfcsolution.springbootmoviesbookinks.exception.UsersException;
import com.gkfcsolution.springbootmoviesbookinks.model.BookingStatus;
import com.gkfcsolution.springbootmoviesbookinks.repository.BookingRepository;
import com.gkfcsolution.springbootmoviesbookinks.repository.ShowRepository;
import com.gkfcsolution.springbootmoviesbookinks.repository.UserRepository;
import com.gkfcsolution.springbootmoviesbookinks.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created on 2025 at 18:16
 * File: BookingServiceImpl.java.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 13/12/2025
 * @time 18:16
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;
    private final UserRepository userRepository;
    @Override
    public Booking createBooking(BookingDTO bookingDTO) {
        Show show = showRepository.findById(bookingDTO.getShowId()).orElseThrow(() -> new ShowException("Show Not Found !"));

        if (!isSeatsAvailable(show.getId(), bookingDTO.getNumberOfSeats())) {
            throw new ShowException("Requested seats are not available");
        }

        if (bookingDTO.getSeatNumbers().size() != bookingDTO.getNumberOfSeats()) {
            throw new ShowException("Number of seats does not match the seat numbers provided");
        }

        validateDuplicateSeats(show.getId(), bookingDTO.getSeatNumbers());

        User user = userRepository.findById(bookingDTO.getUserId()).orElseThrow(() -> new UsersException("User Not Found !"));

        Booking booking = Booking.builder()
                .user(user)
                .show(show)
                .numberOfSeats(bookingDTO.getNumberOfSeats())
                .seatNumbers(bookingDTO.getSeatNumbers())
                .price(calculateTotalAmount(show.getPrice(), bookingDTO.getNumberOfSeats()))
                .bookingTime(LocalDateTime.now())
                .bookingStatus(BookingStatus.PENDING)
                .build();

        return bookingRepository.save(booking);
    }

    private Double calculateTotalAmount(Double price, Integer numberOfSeats) {
        return price * numberOfSeats;
    }

    @Override
    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public List<Booking> getShowBookings(Long showId) {
        return bookingRepository.findByShowId(showId);
    }

    @Override
    public Booking confirmBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new BookingException("Booking Not Found !"));

        if (booking.getBookingStatus() != BookingStatus.PENDING) {
            throw new BookingException("Only pending bookings can be confirmed");
        }

        // PAYMENT Process
        booking.setBookingStatus(BookingStatus.CONFIRMED);

        return bookingRepository.save(booking);
    }

    @Override
    public Booking cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new BookingException("Booking Not Found !"));

        if (booking.getBookingStatus() != BookingStatus.PENDING) {
            throw new BookingException("Only pending bookings can be confirmed");
        }

        validateCancellation(booking);

        booking.setBookingStatus(BookingStatus.CANCELLED);
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByStatus(String bookingStatus) {
        return null;
    }

    private boolean isSeatsAvailable(Long showId, Integer numberOfSeats) {
        Show show = showRepository.findById(showId).orElseThrow(() -> new ShowException("Show Not Found !"));

        int bookedSeats = show.getBookings().stream()
                .filter(booking -> booking.getBookingStatus() != BookingStatus.CANCELLED)
                .mapToInt(Booking::getNumberOfSeats)
                .sum();

        return (show.getTheater().getTheaterCapacity() - bookedSeats) >= numberOfSeats;
    }

    private void validateDuplicateSeats(Long showId, List<String> seatNumbers) {
        Show show = showRepository.findById(showId).orElseThrow(() -> new ShowException("Show Not Found !"));

        Set<String> occupiedSeats = show.getBookings().stream()
                .filter(booking -> booking.getBookingStatus() != BookingStatus.CANCELLED)
                .flatMap(booking -> booking.getSeatNumbers().stream())
                .collect(Collectors.toSet());

        List<String> duplicateSeats = seatNumbers.stream()
                .filter(occupiedSeats::contains)
                .collect(Collectors.toList());

        if (!duplicateSeats.isEmpty()) {
            throw new ShowException("The following seats are already booked: " + String.join(", ", duplicateSeats));
        }
    }

    private void validateCancellation(Booking booking) {
        LocalDateTime showTime = booking.getShow().getShowTime();
        LocalDateTime deadlineTime = showTime.minusHours(2);

        if (LocalDateTime.now().isAfter(deadlineTime)) {
            throw new BookingException("Cancellations are only allowed up to 2 hours before the showtime");
        }

        if (booking.getBookingStatus() == BookingStatus.CANCELLED) {
            throw new BookingException("Booking is already cancelled");
        }

    }
}
