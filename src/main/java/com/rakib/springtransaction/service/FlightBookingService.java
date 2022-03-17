package com.rakib.springtransaction.service;

import com.rakib.springtransaction.dto.FlightBookingAcknowledgement;
import com.rakib.springtransaction.dto.FlightBookingRequest;
import com.rakib.springtransaction.entity.PassengerInfo;
import com.rakib.springtransaction.entity.PaymentInfo;
import com.rakib.springtransaction.repository.PassengerInfoRepository;
import com.rakib.springtransaction.repository.PaymentInfoRepository;
import com.rakib.springtransaction.utils.PaymentUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class FlightBookingService {
    private final PaymentInfoRepository paymentInfoRepository;
    private final PassengerInfoRepository passengerInfoRepository;

    public FlightBookingService(PaymentInfoRepository paymentInfoRepository,
                                PassengerInfoRepository passengerInfoRepository) {
        this.paymentInfoRepository = paymentInfoRepository;
        this.passengerInfoRepository = passengerInfoRepository;
    }

    @Transactional
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {
        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(),
                UUID.randomUUID().toString().split("-")[0], passengerInfo);
    }
}
