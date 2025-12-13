package com.gkfcsolution.springbootmoviesbookinks.repository;

import com.gkfcsolution.springbootmoviesbookinks.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 2025 at 18:15
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 13/12/2025
 * @time 18:15
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);
    List<Booking> findByShowId(Long showId);
}
