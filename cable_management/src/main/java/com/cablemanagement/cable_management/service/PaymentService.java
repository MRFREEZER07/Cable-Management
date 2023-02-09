package com.cablemanagement.cable_management.service;

import com.cablemanagement.cable_management.entity.Payment;

public interface PaymentService {
    Payment getPayment(Long id);

    Payment addPayment(Long id, Long amountPaid);

    Payment updatePayment(Long id, Payment payment);

    Long createDue(Long amount, String type);

    Payment addHistory(Long id , Payment payment);
    

}
