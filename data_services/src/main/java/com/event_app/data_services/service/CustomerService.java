package com.event_app.data_services.service;

import java.util.Collection;

import com.event_app.data_services.model.Customer;
import org.springframework.stereotype.Component;

public interface CustomerService {
	
    public Customer findById(Long id);
	
	public Collection<Customer> findAll();

}