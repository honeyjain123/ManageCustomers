package com.example.manageCustomer.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.example.manageCustomer.model.Customer;

import java.util.List;

@FeignClient(value="Customer-Service",url = "localhost:8111")
public interface CustomerProxy {
	
    @PostMapping("/customerservice/customer/")
    public String createCustomer(@RequestBody Customer c);
    
    @GetMapping("/customerservice/customer/")
    public List<Customer> getAll();
    
    @GetMapping("/customerservice/customer/{id}")
    public Customer getCustomerById(@PathVariable long id);
    
    @PutMapping("/customerservice/customer/{id}")
    public String updateCustomer(@PathVariable long id, @RequestBody Customer customerRequestModel);
    
    @DeleteMapping("/customerservice/customer/{id}")
    public String deleteCustomer(@PathVariable long id);
    
    }


