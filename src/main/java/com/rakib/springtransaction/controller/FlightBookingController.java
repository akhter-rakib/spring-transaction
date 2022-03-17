package com.rakib.springtransaction.controller;

import com.rakib.springtransaction.dto.FlightBookingAcknowledgement;
import com.rakib.springtransaction.dto.FlightBookingRequest;
import com.rakib.springtransaction.service.FlightBookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightBookingController {
    private final FlightBookingService bookingService;

    public FlightBookingController(FlightBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("bookFlightTicket")
    public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request) {
        return bookingService.bookFlightTicket(request);
    }
}
