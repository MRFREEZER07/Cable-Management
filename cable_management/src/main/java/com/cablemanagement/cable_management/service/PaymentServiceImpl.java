package com.cablemanagement.cable_management.service;


import java.util.Date;  
import java.text.SimpleDateFormat;
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

    //need to add update payment
    //we can use this for both add 
    @Override
    public Payment addPayment(Long id, Payment payment) {
        
        Optional<Customer> customer = customerRepository.findById(id);
        Customer unwrapedCustomer = unwrapCustomer(customer,id);
        payment.setCustomer(unwrapedCustomer);

        
        if(unwrapedCustomer.getPack().equals("sports")){
            payment.setDue(payment.getSportsPrice() - payment.getPaid());
        }
        if(unwrapedCustomer.getPack().equals("normal")){
            payment.setDue(payment.getNormalPrice() - payment.getPaid());
        }
        if(unwrapedCustomer.getPack().equals("custom")){
            return null;
        }
        payment.setPaymentDate(getDate());
        addHistory(payment,unwrapedCustomer);
        return paymentRepository.save(payment);
    }

   

    public String getDate(){
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        return simpleDateFormat.format(date);
       
    }

    @Override
    public  void addHistory( Payment payment,Customer customer) {
        History history = new History();
        history.setAmountPaid(payment.getPaid());
        history.setDue(payment.getDue());
        history.setPaymentDate(payment.getPaymentDate());
        history.setAmountPaid(payment.getPaid());
        history.setCustomer(customer);
        historyRepository.save(history);
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
