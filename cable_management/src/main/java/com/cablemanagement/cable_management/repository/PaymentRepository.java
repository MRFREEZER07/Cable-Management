package com.cablemanagement.cable_management.repository;

import org.springframework.data.repository.CrudRepository;

import com.cablemanagement.cable_management.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
