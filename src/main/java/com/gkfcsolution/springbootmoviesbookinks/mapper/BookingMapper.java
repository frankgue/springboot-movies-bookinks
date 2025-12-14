package com.gkfcsolution.springbootmoviesbookinks.mapper;

import com.gkfcsolution.springbootmoviesbookinks.dto.BookingResponseDto;
import com.gkfcsolution.springbootmoviesbookinks.entity.Booking;

/**
 * Created on 2025 at 20:13
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 20:13
 */
public class BookingMapper {
    public static BookingResponseDto toDto(Booking booking) {
        return BookingResponseDto.builder()
                .id(booking.getId())
                .numberOfSeats(booking.getNumberOfSeats())
                .bookingTime(booking.getBookingTime())
                .price(booking.getPrice())
                .bookingStatus(booking.getBookingStatus())
                .seatNumbers(booking.getSeatNumbers())
                .user(booking.getUser())
                .show(booking.getShow())
                .build();
    }
}
