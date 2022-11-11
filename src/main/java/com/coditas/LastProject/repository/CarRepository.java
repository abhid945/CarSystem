package com.coditas.LastProject.repository;

import com.coditas.LastProject.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity,Long> {
    CarEntity findByCarId(Long carId);


}
