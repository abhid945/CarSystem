package com.coditas.LastProject.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", nullable = false)
    private Long carId;

    private String modelName;

    @Column(nullable = false)
    private float carPrice;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "seller_entity_seller_id")
    private SellerEntity sellerEntity;

    @OneToOne(mappedBy = "car", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Booking booking;

}
