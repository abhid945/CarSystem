package com.coditas.LastProject.repository;

import com.coditas.LastProject.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
