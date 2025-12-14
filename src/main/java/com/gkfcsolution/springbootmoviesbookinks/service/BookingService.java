package com.gkfcsolution.springbootmoviesbookinks.service;

import com.gkfcsolution.springbootmoviesbookinks.dto.BookingDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.Booking;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created on 2025 at 18:16
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 13/12/2025
 * @time 18:16
 */
public interface BookingService {
    Booking createBooking( BookingDTO bookingDTO);
    List<Booking> getUserBookings( Long userId);
    List<Booking> getShowBookings( Long showId);
    Booking confirmBooking( Long bookingId);
    Booking cancelBooking( Long bookingId);
    List<Booking> getBookingsByStatus(String bookingStatus);
    List<Booking> getAllBookings();
}
