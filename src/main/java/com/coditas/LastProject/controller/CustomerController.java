package com.coditas.LastProject.controller;


import com.coditas.LastProject.entities.Booking;
import com.coditas.LastProject.entities.CarEntity;
import com.coditas.LastProject.model.request.BookingRequestDto;
import com.coditas.LastProject.model.request.CarRequestDto;
import com.coditas.LastProject.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    BookingService bookingService;

    @PostMapping("/addBooking")
    public ResponseEntity createBooking(@RequestBody BookingRequestDto bookingRequestDto) {
        try {
            return new ResponseEntity(Optional.of(bookingService.addBooking(bookingRequestDto)), HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteBooking/{bookingId}")
    public ResponseEntity deleteCar(@PathVariable String bookingId) {
        try {
          bookingService.deleteBooking(Long.valueOf(bookingId));
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getBookings")
    public ResponseEntity getBookings() {
        try {
            List<Booking> bookings = bookingService.fetchAllBooking();
            if (bookings.size() > 0) {
                return new ResponseEntity(bookings, HttpStatus.OK);
            } else {
                return new ResponseEntity(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }





}
