package com.example.manageCustomer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Customer Address Details Model reference from CustomerAddressPortal Microservice")
public class Address {
        
		@ApiModelProperty(notes = "ID for unique identification of a Customer")
    	private long id;
    	@ApiModelProperty(notes = "Address of a Customer")
    	private String addresses;
    	@ApiModelProperty(notes = "Phone Number of a Customer")
    	private String phone;
    	@ApiModelProperty(notes = "Email Address of a Customer")
    	private String email;
    	
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getAddresses() {
            return addresses;
        }

        public void setAddresses(String addresses) {
            this.addresses = addresses;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + addresses + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

	public Address() {
		
	}

	public Address(long id, String addresses, String phone, String email) {
		super();
		this.id = id;
		this.addresses = addresses;
		this.phone = phone;
		this.email = email;
	}
	
}

