package com.event_app.data_services.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @RequestMapping
    public Collection<Customer> findAllCustomers() {
        Collection<Customer> customers = customerService.findAll();

        return customers;
    }






}
