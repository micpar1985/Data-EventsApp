package com.event_app.data_services.service;

import java.util.Collection;
import java.util.Optional;

import com.event_app.data_services.model.Customer;

public interface CustomerService {
	
<<<<<<< HEAD
   // public Customer findById(Long id);
=======
    Optional<Customer> findById(Long id);
>>>>>>> feca54aff7cb1df55aa08e0826d7ba91103a188e
	
	//public Collection<Customer> findAll();
	
	//public Customer findByName(String name);
	
	public Iterable<Customer> findAllCustomers();
	
	public Optional<Customer> findCustomerById(long id);

	public void save(Customer customer); 
	
	public void update(Customer customer);
	
	public void delete(long id);
}