package com.cablemanagement.cable_management.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.cablemanagement.cable_management.entity.Payment;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping("/customer/payment/{id}")
    public ResponseEntity<Payment> getUserPayments(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Payment> addUserPayment(Payment payment) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updateUserPayment(@RequestBody Payment payment, @PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/customer/due/{id}")
    public ResponseEntity<Payment> getUserDue(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/addDue/{id}")
    public ResponseEntity<Payment> addDue(@PathVariable Long id, @RequestBody Payment payment) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
