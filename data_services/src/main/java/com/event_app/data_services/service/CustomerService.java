package com.event_app.data_services.service;

import java.util.Collection;
import java.util.Optional;

import com.event_app.data_services.model.Customer;

public interface CustomerService {

	Customer findByName(String name);
	
    public Iterable<Customer> findAll();
	
	public Optional<Customer> findById(long id);

	public Customer save(Customer customer); 
	
	public void deleteById(Long id);

}