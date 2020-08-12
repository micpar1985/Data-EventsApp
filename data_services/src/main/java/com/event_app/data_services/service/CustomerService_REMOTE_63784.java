package com.event_app.data_services.service;

import java.util.Collection;
import java.util.Optional;

import com.event_app.data_services.model.Customer;

public interface CustomerService {
	
    Optional<Customer> findById(Long id);
	
	Collection<Customer> findAll();
	
	Customer findByName(String name);

}