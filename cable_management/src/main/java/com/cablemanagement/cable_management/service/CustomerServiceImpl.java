package com.cablemanagement.cable_management.service;

import java.util.List;

import org.springframework.stereotype.Service;
import java.util.Optional;
import com.cablemanagement.cable_management.entity.Customer;
import com.cablemanagement.cable_management.exception.CustomerNotFoundException;
import com.cablemanagement.cable_management.repository.CustomerRepository;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return unwrapCustomer(customer, id);

    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer updateCustomerAddress(Long id, String address) {
        Optional<Customer> customer = customerRepository.findById(id);
        Customer unwrapedCustomer = unwrapCustomer(customer, id);
        unwrapedCustomer.setAddress(address);
        return customerRepository.save(unwrapedCustomer);
    }

    @Override
    public Customer updateCustomerActive(Long id, Long active) {
        Optional<Customer> customer = customerRepository.findById(id);
        Customer unwrapedCustomer = unwrapCustomer(customer, id);
        unwrapedCustomer.setActive(active);
        return customerRepository.save(unwrapedCustomer);
    }

    @Override
    public Customer updateCustomerName(Long id, String name) {
        Optional<Customer> customer = customerRepository.findById(id);
        Customer unwrapedCustomer = unwrapCustomer(customer, id);
        unwrapedCustomer.setName(name);
        return customerRepository.save(unwrapedCustomer);

    }

    @Override
    public Customer updateCustomerType(Long id, String type) {
        Optional<Customer> customer = customerRepository.findById(id);
        Customer unwrapedCustomer = unwrapCustomer(customer, id);
        unwrapedCustomer.setType(type);
        return customerRepository.save(unwrapedCustomer);
    }

    public static Customer unwrapCustomer(Optional<Customer> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new CustomerNotFoundException(id);
        }
    }

}
