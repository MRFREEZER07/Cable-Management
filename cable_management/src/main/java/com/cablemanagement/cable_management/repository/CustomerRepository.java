package com.cablemanagement.cable_management.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import com.cablemanagement.cable_management.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findById(long id);
}
