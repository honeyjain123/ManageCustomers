package com.example.manageCustomer.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.manageCustomer.model.Address;

@FeignClient(value = "Address-Service", url = "localhost:8000")
public interface AddressProxy {
	
	@PostMapping("/addressservice/customeraddress/")
    public String createAddress(@RequestBody Address a);
	
    @GetMapping("/addressservice/customeraddress/")
    public List<Address> getAddress();
    
    @GetMapping("/addressservice/customeraddress/{id}")
    public Address getAddressById(@PathVariable long id);
    
    @PutMapping("/addressservice/customeraddress/{id}")
    public String updateAddress(@PathVariable long id, @RequestBody Address a);
    
    @DeleteMapping("/addressservice/customeraddress/{id}")
    public String deleteAddress(@PathVariable long id);
}
