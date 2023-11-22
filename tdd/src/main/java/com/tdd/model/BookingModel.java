package com.tdd.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BookingModel {

    private String id;

    private String reserveName;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private Integer numberGuests;


}
