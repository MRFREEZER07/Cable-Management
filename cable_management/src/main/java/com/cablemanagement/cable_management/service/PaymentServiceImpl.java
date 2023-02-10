package com.cablemanagement.cable_management.service;


import java.util.Optional;


import org.springframework.stereotype.Service;

import com.cablemanagement.cable_management.entity.Customer;
import com.cablemanagement.cable_management.entity.History;
import com.cablemanagement.cable_management.entity.Payment;
import com.cablemanagement.cable_management.exception.CustomerNotFoundException;
import com.cablemanagement.cable_management.exception.PaymentNotFoundException;
import com.cablemanagement.cable_management.repository.CustomerRepository;
import com.cablemanagement.cable_management.repository.HistoryRepository;
import com.cablemanagement.cable_management.repository.PaymentRepository;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor

@Service
public class PaymentServiceImpl implements PaymentService {
    CustomerRepository customerRepository;
    PaymentRepository paymentRepository;
    HistoryRepository historyRepository;

    @Override
    public Payment getPayment(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        Payment unwrapCustomer = unwrapPayment(payment, id);
        return unwrapCustomer;
    }

    @Override
    public Payment addPayment(Long id, Payment payment) {
        Optional<Customer> customer = customerRepository.findById(id);
        Customer unwrapedCustomer = unwrapCustomer(customer,id);
        
        Long due;
        if(unwrapedCustomer.getPack() == "sports"){
            due = payment.getSportsPrice() - payment.getAmountPaid();
            payment.setDue(due);
        }
        if(unwrapedCustomer.getPack()=="normal"){
            due = payment.getNormalPrice() - payment.getAmountPaid();
            payment.setDue(due);
        }
        if(unwrapedCustomer.getPack()=="custom"){
            return null;
        }
        addHistory(payment);
        return paymentRepository.save(payment);
    }

    // @Override
    // public Payment updatePayment(Long id, Payment payment) {
    //     return null;
    // }

    

    @Override
    public  Payment addHistory( Payment payment) {
        History history = new History();
        history.setAmountPaid(payment.getAmountPaid());
        history.setDue(payment.getDue());
        history.setAmountPaid(payment.getAmountPaid());
        historyRepository.save(history);
        return null;
    }

    

    public static Payment unwrapPayment(Optional<Payment> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new PaymentNotFoundException(id);
        }
    }

    public static Customer unwrapCustomer(Optional<Customer> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new CustomerNotFoundException(id);
        }
    }
   

}
