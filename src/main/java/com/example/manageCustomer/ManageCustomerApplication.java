package com.example.manageCustomer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
@EnableDiscoveryClient

public class ManageCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageCustomerApplication.class, args);
	}

	@Bean
	public Docket swaggerconfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/managecustomer/**"))
				.build()
				.apiInfo(apidetails());
	}
	
	private ApiInfo apidetails()
	{
		Contact contact = new Contact(
	               "Honey Jain",
	               "https://www.honeyjain.com", 
	               "honey@jain.com"
	       );
		
		List<VendorExtension> vendorExtensions = new ArrayList<>();
		return new ApiInfo("Wrapper Microservice Documentaion", "Sample Document for Consumer Details", "1.0", "https://www.honeyjain.com",contact, "Free", "HJ",vendorExtensions);
	}

}
