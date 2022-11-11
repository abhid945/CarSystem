package com.coditas.LastProject.service;

import com.coditas.LastProject.entities.CustomerEntity;
import com.coditas.LastProject.entities.SellerEntity;
import com.coditas.LastProject.model.request.SellerRequestDto;
import com.coditas.LastProject.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SellerServiceImplementation implements SellerService{


    @Autowired
    SellerRepository sellerRepository;


    @Override
    public SellerEntity addSeller(SellerRequestDto sellerRequestDto) {
      SellerEntity seller = new SellerEntity();
      seller.setSellerID(sellerRequestDto.getSellerID());
      seller.setSellerName(sellerRequestDto.getSellerName());
      return sellerRepository.save(seller);
    }

    @Override
    public void deleteSeller(Long sellerId) {
        sellerRepository.deleteById(sellerId);
    }

    @Override
    public List<SellerEntity> fetchAllSeller() {
        return sellerRepository.findAll();
    }

    @Override
    public SellerEntity updateSeller(SellerRequestDto sellerRequestDto) {
        SellerEntity seller = sellerRepository.findById(sellerRequestDto.getSellerID()).orElse(null);
        if (seller != null) {
            seller.setSellerName(seller.getSellerName());
        }
        return null;
    }

}
