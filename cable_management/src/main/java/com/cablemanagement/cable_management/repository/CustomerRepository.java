package com.cablemanagement.cable_management.repository;

import org.springframework.data.repository.CrudRepository;

import com.cablemanagement.cable_management.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
