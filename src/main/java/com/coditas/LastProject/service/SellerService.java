package com.coditas.LastProject.service;

import com.coditas.LastProject.entities.CustomerEntity;
import com.coditas.LastProject.entities.SellerEntity;
import com.coditas.LastProject.model.request.CustomerRequestDto;
import com.coditas.LastProject.model.request.SellerRequestDto;

import java.util.List;

public interface SellerService {

    SellerEntity addSeller(SellerRequestDto sellerResquestDto);


    void deleteSeller(Long sellerId);

    List<SellerEntity> fetchAllSeller();

    SellerEntity updateSeller(SellerRequestDto sellerRequestDto);
}
