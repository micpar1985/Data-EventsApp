package com.event_app.data_services.repository;

import java.util.Collection;

import com.event_app.data_services.model.Customer;
import org.springframework.stereotype.Component;

//import com.event_app.data_services
public interface CustomerRepository { 

		public String findById(Long id);
		
		public Collection<Customer> findAll();
		
		public Collection<Customer> findByName(String name);
		
		//public long count();
		
		//public Customer save(Customer customer);
		
		//public void delete(Customer customer);
		
	
}
