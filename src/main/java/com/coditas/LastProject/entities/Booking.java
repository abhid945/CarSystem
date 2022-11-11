package com.coditas.LastProject.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false)
    private Long bookingId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_customer_id")
    private CustomerEntity customer;


    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "car_car_id")
    private CarEntity car;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "seller_entity_seller_id")
    private SellerEntity sellerEntity;


}
