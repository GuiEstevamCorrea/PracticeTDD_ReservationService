package com.tdd.service;

import com.tdd.model.BookingModel;
import com.tdd.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public int daysClaculatorWithDatabase(String name) {
        Optional<BookingModel> bookingModelOptional = bookingRepository.findByReserveName(name);
        return Period.between(bookingModelOptional.get().getCheckIn(), bookingModelOptional.get().getCheckOut()).getDays();
    }
}
