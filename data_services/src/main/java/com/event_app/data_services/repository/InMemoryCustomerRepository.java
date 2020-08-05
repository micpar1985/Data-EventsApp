package com.event_app.data_services.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.event_app.data_services.model.Customer;

public class InMemoryCustomerRepository implements CustomerRepository {

	
	private List<Customer> customerData = new ArrayList<>(Arrays.asList(
		new Customer( "JDaddy", "JJ", "JJ@gmail.com"),
		new Customer("LCat","LL", "LL@Hotmail.com")));
			
	@Override
	public Collection<Customer> findAll() {
			return Collections.unmodifiableCollection(customerData);
	}
		
}
