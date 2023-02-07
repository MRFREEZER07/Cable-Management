package com.cablemanagement.cable_management.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cablemanagement.cable_management.entity.Payment;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    
    
    @GetMapping("/{userId}")
    public ResponseEntity<Payment> getUserPayments(@PathVariable Long userId) {
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
