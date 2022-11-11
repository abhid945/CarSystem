package com.coditas.LastProject.model.request;


import lombok.Data;

@Data
public class BookingRequestDto {

    private Long bookingId;
    private Long customerId;
    private Long carId;
    private Long sellerId;

}
