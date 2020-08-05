package com.event_app.data_services.service;

import java.util.Collection;
import java.util.List;

import com.event_app.data_services.model.Customer;
import com.event_app.data_services.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override 
	public Customer findById(Long id) {
		
		return customerRepository.findById(id);
		
	}
	
	@Override 
	public Collection<Customer> findAll(){
		
		return customerRepository.findAll();
	}
	
	
	
}
