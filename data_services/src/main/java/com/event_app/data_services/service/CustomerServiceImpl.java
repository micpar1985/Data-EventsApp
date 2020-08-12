package com.event_app.data_services.service;

import java.util.Collection;

import java.util.List;
import java.util.Optional;

import com.event_app.data_services.model.Customer;
import com.event_app.data_services.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	/*
	 * @Override public Customer findById(Long id) {
	 * 
	 * return customerRepository.findById(id);
	 * 
	 * }
	 */
	
	/*
	 * @Override public Collection<Customer> findAll(){
	 * 
	 * return customerRepository.findAll(); }
	 * 
	 * @Override public Customer findByName(String name){
	 * 
	 * return customerRepository.findByName(name); }
	 */
	
	
	@Override
	public Iterable<Customer> findAllCustomers(){
		
		return customerRepository.findAll();
	}
	
	@Override
	public Optional<Customer> findCustomerById(long id){
	
		return customerRepository.findById(id);
	}
	
    @Override
	public void save(Customer customer){
		
		return customerRepository.save(customer);
	}
	
	@Override
	public void update(Customer customer) {
		
		return customerRepository.update(customer);
		
	}
	
	@Override
	public void delete(Long id) {
		
		return customerRepository.remove(id);
		
		
	}
}
