package com.coditas.LastProject.model.request;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CarRequestDto {

    private Long carId;

    private String modelName;

    @Column(nullable = false)
    private float carPrice;

    private Long sellerId;

}
