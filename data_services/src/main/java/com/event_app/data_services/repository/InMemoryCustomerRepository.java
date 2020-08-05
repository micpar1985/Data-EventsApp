package com.event_app.data_services.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.event_app.data_services.model.Customer;
import com.sun.el.stream.Optional;

@Component
public class InMemoryCustomerRepository implements CustomerRepository {

	
	private List<Customer> customerData = new ArrayList<>(Arrays.asList(
		new Customer( 01L,"JDaddy", "JJ", "JJ@gmail.com"),
		new Customer( 02L, "LCat","LL", "LL@Hotmail.com")));
	
		
	@Override
	public Customer findById(Long id) {
		Optional<Customer> customerOptional = customerData.stream().filter(customer -> customer.getId().equals(id)).findAny();
		
		return customerOptional.orElse(null);
	}
	
	@Override
	public Collection<Customer> findAll() {
			return Collections.unmodifiableCollection(customerData);
	}
	

}
