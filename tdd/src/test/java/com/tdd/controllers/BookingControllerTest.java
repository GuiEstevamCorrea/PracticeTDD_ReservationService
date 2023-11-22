package com.tdd.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdd.model.BookingModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        mockMvc = MockMvcBuilders.standaloneSetup(new BookingController()).build();
    }

    @Test
    public void bookingTestGetAll() throws Exception {
        mockMvc.perform(get("/bookings"))
                .andExpect(status().isOk());
    }

    @Test
    public void bookingTestSave() throws Exception {
        LocalDate checkIn = LocalDate.parse("2020-11-10");
        LocalDate checkOut = LocalDate.parse("2020-11-20");

        BookingModel bookingModel = new BookingModel("1", "Guilherme", checkIn, checkOut, 2);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/bookings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookingModel)))
                .andExpect(status().isOk());
    }

    @Test
    public void bookingTestUpdate() throws Exception {
        LocalDate checkIn = LocalDate.parse("2020-11-10");
        LocalDate checkOut = LocalDate.parse("2020-11-20");

        BookingModel bookingModel = new BookingModel("1", "Guilherme", checkIn, checkOut, 2);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/bookings/{id}", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookingModel)))
                .andExpect(status().isOk());
    }

    @Test
    public void bookingTestDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/bookings/{id}", "1"))
                .andExpect(status().isNoContent());
    }
}
