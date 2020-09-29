package com.event_app.data_services.repository;

import com.event_app.data_services.model.Customer;
import org.springframework.data.repository.CrudRepository;


public interface
CustomerRepository extends CrudRepository<Customer, Long> {

	Customer findByName(String name);
}