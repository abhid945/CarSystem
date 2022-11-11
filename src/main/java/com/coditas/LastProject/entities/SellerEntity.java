package com.coditas.LastProject.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class SellerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id", nullable = false)
    private Long sellerID;

    private String sellerName;

    @OneToMany(mappedBy = "sellerEntity", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CarEntity> cars = new ArrayList<>();

    @OneToMany(mappedBy = "sellerEntity", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Booking> bookings = new ArrayList<>();

}
