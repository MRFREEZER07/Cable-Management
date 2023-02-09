package com.cablemanagement.cable_management.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cablemanagement.cable_management.entity.Payment;
import com.cablemanagement.cable_management.exception.PaymentNotFoundException;
import com.cablemanagement.cable_management.repository.PaymentRepository;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor

@Service
public class PaymentServiceImpl implements PaymentService {

    PaymentRepository paymentRepository;

    @Override
    public Payment getPayment(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        Payment unwrapedPayment = unwrapPayment(payment, id);
        return unwrapedPayment;
    }

    @Override
    public Payment addPayment(Long id, Long amountPaid) {
        // calculate due based on type and packs
        return null;
    }

    @Override
    public Payment updatePayment(Long id, Payment payment) {
        return null;
    }

    @Override
    public Long createDue(Long amount, String type) {
        return null;
    }

    @Override
    public Payment addHistory(Long id, Payment payment) {
        return null;
    }

    public static Payment unwrapPayment(Optional<Payment> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new PaymentNotFoundException(id);
        }
    }

   

}
