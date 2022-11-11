package com.coditas.LastProject.controller;

import com.coditas.LastProject.entities.Booking;
import com.coditas.LastProject.entities.CustomerEntity;
import com.coditas.LastProject.model.request.BookingRequestDto;
import com.coditas.LastProject.model.request.CarRequestDto;
import com.coditas.LastProject.model.request.CustomerRequestDto;
import com.coditas.LastProject.model.request.SellerRequestDto;
import com.coditas.LastProject.service.CustomerService;
import com.coditas.LastProject.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {


    @Autowired
    CustomerService customerService;

    @Autowired
    SellerService sellerService;

    @PostMapping("/addCustomer")
    public ResponseEntity createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        try {
            return new ResponseEntity(Optional.of(customerService.addCustomer(customerRequestDto)), HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity deleteCustomer(@PathVariable String customerId) {
        try {
            customerService.deleteCustomer(Long.valueOf(customerId));
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updateCustomer")
    public ResponseEntity updateCar(@RequestBody CustomerRequestDto customerRequestDto) {
        try {
            return new ResponseEntity(Optional.of(customerService.updateCustomer(customerRequestDto)), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getCustomers")
    public ResponseEntity getCustomers() {
        try {
            List<CustomerEntity> customers = customerService.fetchAllCustomers();
            if (customers.size() > 0) {
                return new ResponseEntity(customers, HttpStatus.OK);
            } else {
                return new ResponseEntity(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }


    @PostMapping("/addSeller")
    public ResponseEntity createSeller(@RequestBody SellerRequestDto sellerRequestDto) {
        try {
            return new ResponseEntity(Optional.of(sellerService.addSeller(sellerRequestDto)), HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
