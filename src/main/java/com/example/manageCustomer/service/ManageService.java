package com.example.manageCustomer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.manageCustomer.model.Address;
import com.example.manageCustomer.model.Customer;
import com.example.manageCustomer.model.CustomerWithAddress;
import com.example.manageCustomer.repository.AddressProxy;
import com.example.manageCustomer.repository.CustomerProxy;

@Service
public class ManageService {
	
	@Autowired
	CustomerProxy customerproxy;
    
    @Autowired
    AddressProxy addressproxy;

	public String createCustomerWithAddress(CustomerWithAddress customerwithaddress) {
		
		Customer customer = customerwithaddress.getCustomer();
		Address address = customerwithaddress.getAddress();
		
		customerproxy.createCustomer(customer);
		addressproxy.createAddress(address);
		
		return "Customer with Address Created successfully";
	}

	public String deleteCustomerWithAddress(long id) 
	{
		customerproxy.deleteCustomer(id);
		addressproxy.deleteAddress(id);
		return "Customer With Address Deleted";
	}

	public List<CustomerWithAddress> getCustomerWithAddress() 
	{	
		List<Customer> customerlist = customerproxy.getAll();
		List<Address> addresslist = addressproxy.getAddress();
		
		List<CustomerWithAddress> templist = new ArrayList<CustomerWithAddress>();
		for(int i=0;i<customerlist.size();i++)
		{
			CustomerWithAddress customerwithaddress = new CustomerWithAddress();
			Customer c = customerlist.get(i);
			Address a = addresslist.get(i);
			customerwithaddress.setCustomer(c);
			customerwithaddress.setAddress(a);			
			templist.add(customerwithaddress);
		}	
		return templist;
	}

	public String updateCustomerWithAddress(long id, CustomerWithAddress customerwithaddress) 
	{	
		customerproxy.updateCustomer(id, customerwithaddress.getCustomer());
		addressproxy.updateAddress(id, customerwithaddress.getAddress());
		return "Customer Details updated successfully...";
	}

	public CustomerWithAddress getCustomerWithAddress(long id) 
	{
		Customer customer = customerproxy.getCustomerById(id);
		Address address = addressproxy.getAddressById(id);
		
		CustomerWithAddress customerwithaddress = new CustomerWithAddress();
		customerwithaddress.setAddress(address);
		customerwithaddress.setCustomer(customer);
		return customerwithaddress;
	}
}