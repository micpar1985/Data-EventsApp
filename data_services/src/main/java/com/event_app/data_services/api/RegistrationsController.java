package com.event_app.data_services.api;

import com.event_app.data_services.model.Registration;
import com.event_app.data_services.service.RegistrationService;
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
@RequestMapping("/registrations")
public class RegistrationsController {

    @Autowired
    RegistrationService registrationService;
    
    @Autowired
    private Tracer tracer;

    @RequestMapping
    public ResponseEntity<?> findAllRegistrations() {
    	
    	Span span = tracer.buildSpan("Find All Registrations").start();
    	span.setTag("http.status_code", 200);
        Iterable<Registration> registrations = registrationService.findAll();
        ResponseEntity<?> response = ResponseEntity.ok(registrations);
        span.finish();
        return response;
    }

    @RequestMapping("/{id}")
    public ResponseEntity<?> findRegistrationById(@PathVariable("id") Long id) {

    	//---- Start Jaeger Span ----//
    	Span span = tracer.buildSpan("Find Registration by ID").start();
    	ResponseEntity<?> response;
    	
    	try {
    		Optional<Registration> registration = registrationService.findById(id);
    		response = ResponseEntity.ok(registration.get());
    		span.setTag("http.status_code",  200);
    	}
    	catch(NoSuchElementException e){
    		response = ResponseEntity.notFound().build();
    		span.setTag("http.status_code",  404);
    	}
    	
    	//---- Finish Span ----//
        span.finish();
        return response;
    }

    @PostMapping
    public ResponseEntity<?> addRegistration(@RequestBody Registration newRegistration,
                                         UriComponentsBuilder uri) {

    	//---- Start Jaeger Span ----//
    	Span span = tracer.buildSpan("Add Registration").start();
    	ResponseEntity<?> response;
    	
        if (newRegistration.getId() != 0 || newRegistration.getNotes() == null
                || newRegistration.getRegistration_date() == null) {
            response = ResponseEntity.badRequest().build();
            span.setTag("http.status_code",  400);
            span.finish();
            return response;
        }
        newRegistration=registrationService.save(newRegistration);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newRegistration.getId()).toUri();
        response = ResponseEntity.created(location).build();
        span.setTag("http.status_code",  201);
        span.finish();
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putRegistration(@RequestBody Registration newRegistration,
                                         @PathVariable("id") long id) {
    	//---- Start Jaeger Span ----//
    	Span span = tracer.buildSpan("Edit Registration").start();
    	ResponseEntity<?> response;
    	
        if (newRegistration.getId() != id
                || newRegistration.getNotes() == null
                || newRegistration.getRegistration_date() == null) {
            response = ResponseEntity.badRequest().build();
            span.setTag("http.status_code", 400);
            span.finish();
            return response;
        }
        newRegistration = registrationService.save(newRegistration);
        response = ResponseEntity.ok().build();
        span.setTag("http.status_code",  200);
        
        //---- Finish Span ----//
        span.finish();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRegistration(@PathVariable Long id) {
    	//---- Start Jaeger Span ----//
    	Span span = tracer.buildSpan("Add Registration").start();
    	ResponseEntity<?> response;
    	
    	try {
    		registrationService.deleteById(id);
    		response = ResponseEntity.noContent().build();
    		span.setTag("http.status_code", 204);
    	} catch(EmptyResultDataAccessException e) {
    		span.setTag("http.status_code", 404);
    		response = ResponseEntity.notFound().build();
    	}
    	
    	//---- Finish Span ----//
        span.finish();
        return response;
    }


}
