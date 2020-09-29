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

import io.opentracing.Span;
import io.opentracing.Tracer;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    CustomerService customerService;
    
    @Autowired
    private Tracer tracer;

    @RequestMapping
    public ResponseEntity<?> findAllCustomers() {
    	
    	//---- Start Jaeger Span ----//
    	Span span = tracer.buildSpan("Find All Customers").start();
    	
        try {
            Iterable<Customer> customers = customerService.findAll();
            ResponseEntity<?> response = ResponseEntity.ok(customers);
            span.setTag("http.status_code", 200);
            
            span.finish();
            return response;

        } catch (Exception e) {
            ResponseEntity<?> response = ResponseEntity.badRequest().body("Sorry, something went wrong.");
            span.setTag("http.status_code", 400);
            span.finish();
            return response;

        }


    }

    @RequestMapping("/{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable("id") Long id) {

    	//---- Start Jaeger Span ----//
    	Span span = tracer.buildSpan("Find Customer by ID").start();
    	
        try {
            Optional<Customer> customer = customerService.findById(id);
            ResponseEntity<?> response = ResponseEntity.ok(customer.get());
            span.setTag("http.status_code", 200);
            span.finish();
            return response;

        } catch (NoSuchElementException e) {
            ResponseEntity<?> response = ResponseEntity.notFound().build();
            span.setTag("http.status_code", 404);
            span.finish();
            return response;
        }

    }


    @RequestMapping("/byName/{name}")
    public ResponseEntity<?> findCustomerByName(@PathVariable("name") String name) {
    	
    	//---- Start Jaeger Span ----//
    	Span span = tracer.buildSpan("Find Customer by Name").start();

        try {
            Optional<Customer> customer = Optional.ofNullable(customerService.findByName(name));
            ResponseEntity<?> response = ResponseEntity.ok(customer.get());
            
            span.setTag("http.status_code", 200);
            span.finish();
            return response;

        } catch (Exception e) {
            ResponseEntity<?> response = ResponseEntity.badRequest().body("Customer name not found.");
            span.setTag("http.status_code", 400);
            span.finish();
            return response;
        }
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer,
                                         UriComponentsBuilder uri) {
    	
    	//---- Start Jaeger Span ----//
    	Span span = tracer.buildSpan("Add Customer").start();
    	
        try {
            if (newCustomer.getId() != 0 || newCustomer.getName() == null
                    || newCustomer.getEmail() == null) {
                ResponseEntity<?> response = ResponseEntity.badRequest().build();
                span.setTag("http.status_code", 400);
                span.finish();
                return response;
            }


            newCustomer = customerService.save(newCustomer);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(newCustomer.getId()).toUri();
            ResponseEntity<?> response = ResponseEntity.created(location).build();
            span.setTag("http.status_code", 201);
            span.finish();
            return response;
        } catch (Exception e) {
            ResponseEntity<?> response =  ResponseEntity.badRequest().body("Sorry, something went wrong.");
            span.setTag("http.status_code", 400);
            span.finish();
            return response;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putCustomer(@RequestBody Customer newCustomer,
                                         @PathVariable("id") long id) {
    	
    	//---- Start Jaeger Span ----//
    	Span span = tracer.buildSpan("Edit Customer").start();
    	ResponseEntity<?> response;
    	
        try {
            if (newCustomer.getId() != id
                    || newCustomer.getName() == null
                    || newCustomer.getEmail() == null) {
                response = ResponseEntity.badRequest().build();
                
                span.setTag("http.status_code",  400);
                span.finish();
                return response;
            }

            newCustomer = customerService.save(newCustomer);
            response = ResponseEntity.ok().build();
            
            span.setTag("http.status_code",  200);
            span.finish();
            return response;
            
        } catch (Exception e) {
            response = ResponseEntity.notFound().build();
            span.setTag("http.status_code",  404);
            return response;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
    	
    	//---- Start Jaeger Span ----//
    	Span span = tracer.buildSpan("Delete Customer").start();
    	ResponseEntity<?> response;
    	
        try {
            customerService.deleteById(id);
            response = ResponseEntity.noContent().build();
            span.setTag("http.status_code", 204);
        } catch (EmptyResultDataAccessException e) {
            response = ResponseEntity.notFound().build();
            span.setTag("http.status_code",  404);
        }
        
        span.finish();
        return response;
    }
}

