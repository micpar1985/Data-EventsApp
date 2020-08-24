package com.event_app.data_services.api;

import com.event_app.data_services.model.Customer;
import com.event_app.data_services.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    CustomerService customerService;

    @RequestMapping
    public ResponseEntity<?> findAllCustomers() {
        try {
            Iterable<Customer> customers = customerService.findAll();
            ResponseEntity<?> response = ResponseEntity.ok(customers);
            return response;

        } catch (Exception e) {
            ResponseEntity<?> response = ResponseEntity.badRequest().body("Sorry, something went wrong.");
            return response;

        }


    }

    @RequestMapping("/{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable("id") Long id) {

        try {
            Optional<Customer> customer = customerService.findById(id);
            ResponseEntity<?> response = ResponseEntity.ok(customer.get());
            return response;

        } catch (NoSuchElementException e) {
            ResponseEntity<?> response = ResponseEntity.notFound().build();
            return response;
        }

    }


    @RequestMapping("/byName/{name}")
    public ResponseEntity<?> findCustomerByName(@PathVariable("name") String name) {

        try {
            Optional<Customer> customer = Optional.ofNullable(customerService.findByName(name));
            ResponseEntity<?> response = ResponseEntity.ok(customer.get());
            return response;

        } catch (Exception e) {
            ResponseEntity<?> response = ResponseEntity.badRequest().body("Customer name not found.");
            return response;
        }
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer,
                                         UriComponentsBuilder uri) {
        try {
            if (newCustomer.getId() != 0 || newCustomer.getName() == null
                    || newCustomer.getEmail() == null) {
                return ResponseEntity.badRequest().build();
            }


            newCustomer = customerService.save(newCustomer);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(newCustomer.getId()).toUri();
            ResponseEntity<?> response = ResponseEntity.created(location).build();
            return response;
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Sorry, something went wrong.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putCustomer(@RequestBody Customer newCustomer,
                                         @PathVariable("id") long id) {
        try {
            if (newCustomer.getId() != id
                    || newCustomer.getName() == null
                    || newCustomer.getEmail() == null) {
                return ResponseEntity.badRequest().build();

            }

            newCustomer = customerService.save(newCustomer);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        try {
            customerService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

