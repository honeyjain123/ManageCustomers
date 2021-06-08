package com.example.manageCustomer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.manageCustomer.exception.CustomerNotFoundException;
import com.example.manageCustomer.model.Address;
import com.example.manageCustomer.model.Customer;
import com.example.manageCustomer.model.CustomerWithAddress;
import com.example.manageCustomer.repository.AddressProxy;
import com.example.manageCustomer.repository.CustomerProxy;
import com.example.manageCustomer.service.ManageService;

import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/managecustomer")
public class ManageCustomerController {
	
	Logger logger = LoggerFactory.getLogger(ManageCustomerController.class);
	
    @Autowired
    CustomerProxy customerproxy;
    
    @Autowired
    AddressProxy addressproxy;
    
    @Autowired
    ManageService manageservice;
    
	@GetMapping("/customer/")
    @ApiOperation(value = "Display All Customers", notes = "It fetches all the Customers from H2 database of CustomerPortal Microservice")
    public List<Customer> getAll()
    {
		logger.error("Inside GetAllCustomer Method..");
        return customerproxy.getAll();
    }
	
    @GetMapping("/customer/{id}")
    @ApiOperation(value = "Display A Customer", notes = "It fetches a Customer from H2 database of CustomerPortal Microservice")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id) throws CustomerNotFoundException
    {
    	logger.error("Inside GetCustomerById Method..");
        return new ResponseEntity<>(customerproxy.getCustomerById(id),HttpStatus.OK);
    }
    
    @PutMapping("/customer/{id}")
    @ApiOperation(value = "Updates A Customer By its Id", notes = "It updates a particular Customer from H2 database of CustomerPortal Microservice by its Id")
    public String updateCustomer(@PathVariable long id,@RequestBody Customer customer)
    {
    	logger.error("Inside Update Customer Method..");
        return customerproxy.updateCustomer(id,customer);
    }
	
    @GetMapping("/customeraddress/")
    @ApiOperation(value = "Display All Customers", notes = "It fetches all the Customers from H2 database of CustomerAddressPortal Microservice")
    public List<Address> getAddress()
    {
    	logger.error("Inside GetAllAddress Method..");
    	return addressproxy.getAddress();
    }
       
    @GetMapping("/customeraddress/{id}")
    @ApiOperation(value = "Display A Customer Address Details", notes = "It fetches a Customer Address Details from H2 database of CustomerAddressPortal Microservice")
    public Address getAddressById(@PathVariable long id)
    {
    	logger.error("Inside GetAddressById Method..");
    	return addressproxy.getAddressById(id);
    }
    
    @PutMapping("/customeraddress/{id}")
    @ApiOperation(value = "Updates A Customer By its Id", notes = "It updates a particular Customer from H2 database of CustomerAddressPortal Microservice by its Id")
    public String updateAddress(@PathVariable long id, @RequestBody Address address)
    {
    	logger.error("Inside UpdateAddressById Method..");
    	return addressproxy.updateAddress(id, address);
    }
    
	@GetMapping("/customerwithaddress/{id}")
	@ApiOperation(value = "Display A Customer By its Id", notes ="It displays a Customer from H2 databases of CustomerPortal and CustomerAddressPortal Microservices") 
	public CustomerWithAddress getCustomerWithAddress(@PathVariable long id) 
	{
		logger.error("Inside GetCustomerWithAddressById Method..");
		return manageservice.getCustomerWithAddress(id); 
	}
	 
    @PostMapping(value = "/customerwithaddress/", consumes = "application/json")
    @ApiOperation(value = "Creates a new Customer", notes = "It creates a new Customer in CustomerPortal and CustomerAddressPortal Microservice and saves it in H2 database")
	public String createCustomerWithAddress(@RequestBody CustomerWithAddress customerwithaddress)
    {
    	logger.error("Inside PostCustomerWithAddress Method..");
		return manageservice.createCustomerWithAddress(customerwithaddress);
    }
    
    @DeleteMapping("/customerwithaddress/{id}")
    @ApiOperation(value = "Deletes a particular Customer", notes = "It deletes a particular customer from H2 database of CustomerPortal and CustomerAddressPortal Microservice by its Id")
    public String deleteCustomerWithAddress(@PathVariable long id)
    {
    	logger.error("Inside DeleteCustomerWithAddress Method..");
    	return manageservice.deleteCustomerWithAddress(id);
    }
    
    @GetMapping("/customerwithaddress/")
    @ApiOperation(value = "Display All Customers", notes = "It fetches all the Customers from H2 database of CustomerPortal and CustomerAddressPortal Microservice")
    public List<CustomerWithAddress> getCustomerWithAddress()
    {
    	logger.error("Inside GetAllCustomersWithAddress Method..");
    	return manageservice.getCustomerWithAddress();
    }
    
    @PutMapping("/customerwithaddress/{id}")
    @ApiOperation(value = "Updates A Customer By its Id", notes = "It updates a particular Customer from H2 database of CustomerPortal and CustomerAddressPortal Microservice by its Id")
    public String updateCustomerWithAddress(@PathVariable long id, @RequestBody CustomerWithAddress customerwithaddress)
    {
    	logger.error("Inside UpdateCustomerWithAddress Method..");
    	return manageservice.updateCustomerWithAddress(id,customerwithaddress);
    }
}