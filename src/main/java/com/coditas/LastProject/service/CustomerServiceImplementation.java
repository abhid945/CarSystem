package com.coditas.LastProject.service;

import com.coditas.LastProject.entities.Booking;
import com.coditas.LastProject.entities.CarEntity;
import com.coditas.LastProject.entities.CustomerEntity;
import com.coditas.LastProject.model.request.CarRequestDto;
import com.coditas.LastProject.model.request.CustomerRequestDto;
import com.coditas.LastProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImplementation implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public CustomerEntity addCustomer(CustomerRequestDto customerRequestDto) {
        CustomerEntity customer = new CustomerEntity();
        customer.setCustomerId(customerRequestDto.getCustomerId());
        customer.setCustomerName(customerRequestDto.getCustomerName());
        customer.setPhoneNumber(customerRequestDto.getPhoneNumber());
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }


    @Override
    public List<CustomerEntity> fetchAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity updateCustomer(CustomerRequestDto customerRequestDto) {
        CustomerEntity customer = customerRepository.findById(customerRequestDto.getCustomerId()).orElse(null);
        if (customer != null) {
            customer.setCustomerName(customer.getCustomerName());
            customer.setPhoneNumber(customer.getPhoneNumber());
            return customerRepository.save(customer);
        }
        return null;
    }

}
