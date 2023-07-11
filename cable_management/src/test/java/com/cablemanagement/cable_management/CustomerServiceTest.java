package com.cablemanagement.cable_management;

import com.cablemanagement.cable_management.entity.Customer;
import com.cablemanagement.cable_management.repository.CustomerRepository;
import com.cablemanagement.cable_management.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;


//    @Test
//    public void getCustomersFromRepoTest(){
//        when(customerService.getCustomers()).thenReturn( Arrays.asList(
//        new Customer("karthik","brooklyn","22","hd","sports"),
//                new Customer("baalaji","brooklyn","22","hd","sports")
//                ));
//        List<Customer> result = customerService.getCustomers();
//        assertEquals("karthik",result.get(0).getName());
//    }

    @Test
    public void addCustomerTest(){
        Customer customer = new Customer("karthik","brooklyn","22","hd","sports");
        customerService.addNewCustomer(customer);
        assertThat(customerService.getCustomers()).isNotNull();


    }




}
