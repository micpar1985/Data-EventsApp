package com.event_app.data_services.repository;

import java.util.*;
import org.springframework.stereotype.Component;
import com.event_app.data_services.model.Customer;

@Component
public class InMemoryCustomerRepository implements CustomerRepository {

	
	private List<Customer> customerData = new ArrayList<>(Arrays.asList(
		new Customer( 01L,"JDaddy", "JJ", "JJ@gmail.com"),
		new Customer( 02L, "LCat","LL", "LL@Hotmail.com")));
	
		
	@Override
	public String findById(Long id) {
		Optional<Customer> customerOptional = customerData.stream()
				.filter(customer -> customer.getId() == id).findAny();
		
		return customerOptional.map(Customer::getName).orElse(null);
	}
	
	@Override
	public Collection<Customer> findAll() {
			return Collections.unmodifiableCollection(customerData);
	}
	

}
