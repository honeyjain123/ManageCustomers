package com.example.manageCustomer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.manageCustomer.model.Address;
import com.example.manageCustomer.model.Customer;
import com.example.manageCustomer.model.CustomerWithAddress;
import com.example.manageCustomer.service.ManageService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ManageCustomerApplicationTests {

	@Autowired
	private ManageService manageservice;
	
	@Test
	@Order(1)
	public void testcreateCustomerWithAddress() 
	{
		CustomerWithAddress customerwithaddress = new CustomerWithAddress();
		customerwithaddress.setAddress(new Address(1, "India", "123", "mail.com"));
		customerwithaddress.setCustomer(new Customer(1, "Honey", "Jain", "01/01/01"));
		
		manageservice.createCustomerWithAddress(customerwithaddress);
		assertNotNull(manageservice.getCustomerWithAddress());
	}
	
	@Test
	@Order(2)
	public void testgetCustomerWithAddress()
	{
		List<CustomerWithAddress> list = manageservice.getCustomerWithAddress();
		assertThat(list).size().isGreaterThan(0);
	}
	
	
	@Test
	@Order(3)
	public void testupdateCustomerWithAddress()
	{
		CustomerWithAddress customerwithaddress = manageservice.getCustomerWithAddress(1);
		customerwithaddress.setAddress(new Address(customerwithaddress.getAddress().getId(), "ASIA", customerwithaddress.getAddress().getPhone(), customerwithaddress.getAddress().getEmail()));
		customerwithaddress.setCustomer(new Customer(customerwithaddress.getCustomer().getId(), "Sachin", customerwithaddress.getCustomer().getLastname(), customerwithaddress.getCustomer().getDob()));
		
		manageservice.updateCustomerWithAddress(1, customerwithaddress);
		assertNotEquals("India", manageservice.getCustomerWithAddress(1L).getAddress().getAddresses());
		assertNotEquals("Honey", manageservice.getCustomerWithAddress(1L).getCustomer().getFirstname());
	}
	
	
	@Test
	@Order(4)
	public void testdeleteCustomerWithAddress()
	{
		manageservice.deleteCustomerWithAddress(1);
		List<CustomerWithAddress> list = manageservice.getCustomerWithAddress();
		assertThat(list).size().isEqualTo(0);
	}
}