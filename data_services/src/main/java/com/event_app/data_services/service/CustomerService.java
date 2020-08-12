package com.event_app.data_services.service;

import java.util.Collection;
import java.util.Optional;

import com.event_app.data_services.model.Customer;

public interface CustomerService {
	
    Optional<Customer> findById(Long id);
	
	Collection<Customer> findAll();
	
	Customer findByName(String name);
	
    public Iterable<Customer> findAllCustomers();
	
	public Optional<Customer> findCustomerById(long id);

	public void save(Customer customer); 
	
	public void update(Customer customer);
	
	public void delete(long id);

}