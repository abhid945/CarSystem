package com.coditas.LastProject.repository;

import com.coditas.LastProject.entities.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellerEntity,Long> {
    SellerEntity findBySellerID(Long sellerID);
}
