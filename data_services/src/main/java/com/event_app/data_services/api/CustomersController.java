package com.event_app.data_services.api;

import com.event_app.data_services.model.Customer;
import com.event_app.data_services.repository.CustomerRepository;
import com.event_app.data_services.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import com.event_app.data_services.repository.InMemoryCustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    CustomerService customerService;

    @RequestMapping
    public Collection<Customer> findAllCustomers() {
        Collection<Customer> customers = customerService.findAll();

        return customers;
    }






}
