package com.coditas.LastProject.service;

import com.coditas.LastProject.entities.CarEntity;
import com.coditas.LastProject.entities.CustomerEntity;
import com.coditas.LastProject.entities.SellerEntity;
import com.coditas.LastProject.model.request.CarRequestDto;
import com.coditas.LastProject.repository.CarRepository;
import com.coditas.LastProject.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarServiceImplementation implements CarService{


    @Autowired
    CarRepository carRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public CarEntity addCar(CarRequestDto carRequestDto) {
        CarEntity car = new CarEntity();
        car.setCarId(carRequestDto.getCarId());
        car.setCarPrice(carRequestDto.getCarPrice());
        car.setModelName(carRequestDto.getModelName());

        SellerEntity seller = sellerRepository.findBySellerID(carRequestDto.getSellerId());
        car.setSellerEntity(seller);
        return carRepository.save(car);
    }


    @Override
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public CarEntity updateCar(CarRequestDto carRequestDto) {
        CarEntity car = carRepository.findById(carRequestDto.getCarId()).orElse(null);
        if (car != null) {
            car.setCarId(carRequestDto.getCarId());
            car.setCarPrice(carRequestDto.getCarPrice());
            car.setModelName(carRequestDto.getModelName());
            return carRepository.save(car);
        }
        return null;
    }

    @Override
    public List<CarEntity> fetchAllCar() {
        return carRepository.findAll();
    }



}
