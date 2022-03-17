package com.rakib.springtransaction.utils;

import com.rakib.springtransaction.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private static Map<String, Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("acc1", 1234.00);
        paymentMap.put("acc2", 1234.00);
        paymentMap.put("acc3", 9090.00);
        paymentMap.put("acc4", 5454.00);
        paymentMap.put("acc5", 1000.00);
    }

    public static boolean validateCreditLimit(String accNo, double paidAmount) {
        if (paidAmount > paymentMap.get(accNo)) {
            throw new InsufficientAmountException("Insufficient Fund....!");
        }
        return true;
    }
}
