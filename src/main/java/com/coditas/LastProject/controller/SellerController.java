package com.coditas.LastProject.controller;

import com.coditas.LastProject.entities.CarEntity;
import com.coditas.LastProject.model.request.CarRequestDto;
import com.coditas.LastProject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    CarService carService;

    @PostMapping("/addCar")
    public ResponseEntity createTool(@RequestBody CarRequestDto carRequestDto) {
        try {
            return new ResponseEntity(Optional.of(carService.addCar(carRequestDto)), HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/deleteCar/{carId}")
    public ResponseEntity deleteCar(@PathVariable String carId) {
        try {
            carService.deleteCar(Long.parseLong(carId));
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getCars")
    public ResponseEntity getCars() {
        try {
            List<CarEntity> cars = carService.fetchAllCar();
            if (cars.size() > 0) {
                return new ResponseEntity(cars, HttpStatus.OK);
            } else {
                return new ResponseEntity(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/updateCar")
    public ResponseEntity updateCar(@RequestBody CarRequestDto carRequestDto) {
        try {
            return new ResponseEntity(Optional.of(carService.updateCar(carRequestDto)), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
