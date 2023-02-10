package com.cablemanagement.cable_management.service;

import java.util.List;

import org.springframework.stereotype.Service;
import java.util.Optional;
import com.cablemanagement.cable_management.entity.Customer;
import com.cablemanagement.cable_management.exception.ActiveException;
import com.cablemanagement.cable_management.exception.CustomerNotFoundException;
import com.cablemanagement.cable_management.exception.DeActiveException;
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
        Optional<Customer> customer =  customerRepository.findById(id);
        return unwrapCustomer(customer, id);

    }

    @Override
    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

 

    @Override
    public Customer deActivateCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        Customer unwrapedCustomer = unwrapCustomer(customer, id);
        if(unwrapedCustomer.isActive()==true){
            unwrapedCustomer.setActive(false);
        return customerRepository.save(unwrapedCustomer);
        }else{
            throw new ActiveException(unwrapedCustomer.isActive());
        }
        
    }

    @Override 
    public Customer activateCustomer(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        Customer unwrapedCustomer = unwrapCustomer(customer, id);
        if(unwrapedCustomer.isActive()==false){
            unwrapedCustomer.setActive(false);
        return customerRepository.save(unwrapedCustomer);
        }else{
            throw new DeActiveException(unwrapedCustomer.isActive());
        }
    }

 


    @Override
    public Customer updateCustomer(Long id ,Customer customer){
        Optional<Customer> custFromDb = customerRepository.findById(id);
        Customer unwrapedCustomer = unwrapCustomer(custFromDb, id);
        if(customer.getName()!=null){
            unwrapedCustomer.setName(customer.getName());
        }
        if(customer.getAddress()!=null){
            unwrapedCustomer.setAddress(customer.getAddress());
        }
        if(customer.getHouseNo()!=null){
            unwrapedCustomer.setHouseNo(customer.getHouseNo());
        }
        if(customer.getCustomerType()!=null){
            unwrapedCustomer.setCustomerType(customer.getCustomerType());
        }
        if(customer.getPack()!=null){
            unwrapedCustomer.setPack(customer.getPack());
        }
        
        return customerRepository.save(unwrapedCustomer);
    }

 
    @Override
    public  Customer unwrapCustomer(Optional<Customer> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new CustomerNotFoundException(id);
        }
    }


}
