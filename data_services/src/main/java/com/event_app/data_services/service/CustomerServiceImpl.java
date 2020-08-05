package com.event_app.data_services.service;

import java.util.Collection;
import java.util.List;

import com.event_app.data_services.model.Customer;
import com.event_app.data_services.repository.CustomerRepository;

import java.util.ArrayList;

public class CustomerServiceImpl implements CustomerService{

	private CustomerRepository customerRepository;
	
	@Override 
	//public Customer findById(Long id) {
		
		//return customerRepository.findById(id);
		
	//}
	
	public Collection<Customer> findAll(){
		
		return customerRepository.findAll();
	}
	
}
