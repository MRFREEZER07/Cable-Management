package com.cablemanagement.cable_management.service;

import java.util.List;

import com.cablemanagement.cable_management.entity.Customer;

public interface CustomerService {
    List<Customer> getCustomers();

    Customer getCustomer(Long id);

    Customer addCustomer(Customer Customer);

    void deleteCustomer(Long id);

    Customer updateCustomerAddress(Long id, String address);

    Customer updateCustomerActive(Long id, Long active);

    Customer updateCustomerName(Long id, String name);

    Customer updateCustomerType(Long id, String type);
}
