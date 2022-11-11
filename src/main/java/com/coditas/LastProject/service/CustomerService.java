package com.coditas.LastProject.service;

import com.coditas.LastProject.entities.Booking;
import com.coditas.LastProject.entities.CustomerEntity;
import com.coditas.LastProject.model.request.CustomerRequestDto;

import java.util.List;

public interface CustomerService {

    CustomerEntity addCustomer(CustomerRequestDto customerRequestDto);

    void deleteCustomer(Long customerId);

    List<CustomerEntity> fetchAllCustomers();

    CustomerEntity updateCustomer(CustomerRequestDto customerRequestDto);


}

