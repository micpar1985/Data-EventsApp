package com.event_app.data_services.api;

import com.event_app.data_services.model.Customer;
import com.event_app.data_services.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

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

    @RequestMapping("/{id}")
    public Customer findCustomerById(@PathVariable("id") Long id) {
        return customerService.findById(id).get();
    }

    @RequestMapping("/byName/{name}")
    public Customer findCustomerByName(@PathVariable("name") String name) {

        return customerService.findByName(name);
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer,
                                         UriComponentsBuilder uri) {

        if (newCustomer.getId() != 0 || newCustomer.getName() == null
                || newCustomer.getEmail() == null) {
            return ResponseEntity.badRequest().build();
        }
        newCustomer=customerService.save(newCustomer);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newCustomer.getId()).toUri();
        ResponseEntity<?> response=ResponseEntity.created(location).build();
        return response;
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<?> putCustomer(@RequestBody Customer newCustomer,
                                         @PathVariable("customerId") long customerId) {
        if (newCustomer.getId() != customerId
                || newCustomer.getName() == null
                || newCustomer.getEmail() == null) {
            return ResponseEntity.badRequest().build();
        }
        newCustomer = customerService.save(newCustomer);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
    }
}

