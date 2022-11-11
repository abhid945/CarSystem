package com.coditas.LastProject.service;

import com.coditas.LastProject.entities.Booking;
import com.coditas.LastProject.entities.CarEntity;
import com.coditas.LastProject.entities.CustomerEntity;
import com.coditas.LastProject.entities.SellerEntity;
import com.coditas.LastProject.model.request.BookingRequestDto;
import com.coditas.LastProject.model.request.CarRequestDto;
import com.coditas.LastProject.repository.BookingRepository;
import com.coditas.LastProject.repository.CarRepository;
import com.coditas.LastProject.repository.CustomerRepository;
import com.coditas.LastProject.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;


@Service
public class BookingServiceImplementation implements BookingService{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public Booking addBooking(BookingRequestDto bookingRequestDto) {
        Booking booking = new Booking();
        booking.setBookingId(bookingRequestDto.getBookingId());

        CustomerEntity customer = customerRepository.findByCustomerId(bookingRequestDto.getCustomerId());
        booking.setCustomer(customer);

        CarEntity car = carRepository.findByCarId(bookingRequestDto.getCarId());
        booking.setCar(car);

        SellerEntity seller = sellerRepository.findBySellerID(bookingRequestDto.getSellerId());
        booking.setSellerEntity(seller);

        return  bookingRepository.save(booking);
    }


    @Override
    public void deleteBooking(Long bookingId) {
        carRepository.deleteById(bookingId);
    }

    @Override
    public List<Booking> fetchAllBooking() {
        return bookingRepository.findAll();
    }


}
