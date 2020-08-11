package com.event_app.data_services.service;

import java.util.Collection;

import com.event_app.data_services.model.Customer;
import org.springframework.stereotype.Component;

public interface CustomerService {
	
    Customer findById(Long id);
	
	Collection<Customer> findAll();
	
	Collection<Customer> findByName(String name);

}