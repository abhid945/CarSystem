package com.coditas.LastProject.service;

import com.coditas.LastProject.entities.CarEntity;
import com.coditas.LastProject.model.request.CarRequestDto;

import java.util.List;

public interface CarService {

    CarEntity addCar(CarRequestDto carRequestDto);

    List<CarEntity> fetchAllCar();

    void deleteCar(Long carId);


    CarEntity updateCar(CarRequestDto carRequestDto);

}
