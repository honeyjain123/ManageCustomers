package com.example.manageCustomer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Customer with Address Details Model reference from CustomerPortal and CustomerAddressPortal Microservices")
public class CustomerWithAddress {
	
	@ApiModelProperty(notes = "Address Object")
	private Address address;
	@ApiModelProperty(notes = "Customer Object")
	private Customer customer;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CustomerWithAddress() {
		
	}
	public CustomerWithAddress(Address address, Customer customer) {
		super();
		this.address = address;
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomerWithAddress [address=" + address + ", customer=" + customer + "]";
	}
	
}
