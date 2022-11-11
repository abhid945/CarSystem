package com.coditas.LastProject.service;

import com.coditas.LastProject.entities.Booking;
import com.coditas.LastProject.model.request.BookingRequestDto;

import java.util.List;

public interface BookingService {

    Booking addBooking(BookingRequestDto bookingRequestDto);

    void deleteBooking(Long bookingId);


    List<Booking> fetchAllBooking();





}
