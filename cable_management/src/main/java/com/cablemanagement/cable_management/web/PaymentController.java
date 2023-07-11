package com.cablemanagement.cable_management.web;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.cablemanagement.cable_management.service.PaymentService;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getUserPayments(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Payment> addUserPayment(@PathVariable Long id,@RequestBody Payment payment) {
        return new ResponseEntity<>(paymentService.addPayment(id, payment),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updateUserPayment(@RequestBody Payment payment, @PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("due/{id}")
    public ResponseEntity<Payment> getUserDue(@PathVariable Long id) {
        return new ResponseEntity<>(paymentService.getPayment(id),HttpStatus.OK);
    }

   
}
