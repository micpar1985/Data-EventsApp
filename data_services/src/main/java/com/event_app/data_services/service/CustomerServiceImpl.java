package com.event_app.data_services.service;

import java.util.Optional;
import com.event_app.data_services.model.Customer;
import com.event_app.data_services.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer findByName(String name){
	  return customerRepository.findByName(name);
	}
	 
	@Override
	public Iterable<Customer> findAll(){
		return customerRepository.findAll();
	}
		
	@Override
	public Optional<Customer> findById(long id) {
		return customerRepository.findById(id);
	}
		
	@Override
	public Customer save(Customer customer){
		return customerRepository.save(customer);
	}

	@Override
	public void deleteById(Long id) {
		customerRepository.deleteById(id);
	}

}
