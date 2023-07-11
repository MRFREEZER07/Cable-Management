package com.cablemanagement.cable_management;

import com.cablemanagement.cable_management.entity.Customer;
import com.cablemanagement.cable_management.repository.CustomerRepository;
import com.cablemanagement.cable_management.service.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CableManagementApplicationTests {

	@Mock
	public CustomerRepository customerRepository;

	@InjectMocks
	public CustomerServiceImpl customerService;



	@Test
	public void addCustomerTest(){
		Customer customer = new Customer("karthik","brooklyn","22","hd","sports");
		customerService.addNewCustomer(customer);
		assertThat(customerService.getCustomers()).isNull();

	}

}
