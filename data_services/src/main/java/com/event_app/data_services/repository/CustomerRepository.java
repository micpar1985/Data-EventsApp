package com.event_app.data_services.repository;

import com.event_app.data_services.model.Customer;
import org.springframework.data.repository.CrudRepository;
import java.util.Collection;
import java.util.Optional;

public interface
CustomerRepository extends CrudRepository<Customer, Long> {

    /*public Collection<Customer> findAll();

    public Optional<Customer> findById(Long id);

    public Customer findByName(String name);*/
}