package com.coditas.LastProject.repository;

import com.coditas.LastProject.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

    CustomerEntity findByCustomerId(Long customerId);



}
