package com.cablemanagement.cable_management.service;

import java.util.List;
import java.util.Optional;

import com.cablemanagement.cable_management.entity.Customer;

public interface CustomerService {
    List<Customer> getCustomers();

    Customer getCustomer(Long id);

    Customer addNewCustomer(Customer Customer);

    void deleteCustomer(Long id);

    Customer deActivateCustomer(Long id);

    Customer activateCustomer(Long id);

    Customer unwrapCustomer(Optional<Customer> entity, Long id);

    Customer updateCustomer(Long id,Customer customer);
}
