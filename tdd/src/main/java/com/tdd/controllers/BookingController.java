package com.tdd.controllers;

import com.tdd.model.BookingModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @GetMapping
    @ResponseBody
    public String getAll(){
        return "Ok";
    }

    @PostMapping
    public ResponseEntity<BookingModel> save(BookingModel bookingModel){
        return ResponseEntity.status(HttpStatus.OK).body(bookingModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingModel> update(@PathVariable String id, @RequestBody BookingModel updatedBooking) {
        return ResponseEntity.status(HttpStatus.OK).body(updatedBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }
}
