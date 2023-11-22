package com.tdd.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingModel {

    private String id;

    private String reserveName;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private Integer numberGuests;


}
