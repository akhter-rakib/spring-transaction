package com.rakib.springtransaction.dto;

import com.rakib.springtransaction.entity.PassengerInfo;
import com.rakib.springtransaction.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {

    private PassengerInfo passengerInfo;

    private PaymentInfo paymentInfo;
}
