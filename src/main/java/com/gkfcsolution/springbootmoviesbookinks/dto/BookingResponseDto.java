package com.gkfcsolution.springbootmoviesbookinks.dto;

import com.gkfcsolution.springbootmoviesbookinks.entity.Show;
import com.gkfcsolution.springbootmoviesbookinks.entity.User;
import com.gkfcsolution.springbootmoviesbookinks.model.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 2025 at 02:47
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 14/12/2025
 * @time 02:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingResponseDto {
    private Long id;
    private Integer numberOfSeats;
    private LocalDateTime bookingTime;
    private Double price;
    private BookingStatus bookingStatus;
    private List<String> seatNumbers;

    private User user;
    private Show show;
}
