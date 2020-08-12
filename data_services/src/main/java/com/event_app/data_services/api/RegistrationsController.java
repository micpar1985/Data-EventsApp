package com.event_app.data_services.api;

import com.event_app.data_services.model.Registration;
import com.event_app.data_services.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;


@RestController
@RequestMapping("/registrations")
public class RegistrationsController {

    @Autowired
    RegistrationService registrationService;

    @RequestMapping
    public Iterable<Registration> findAllRegistrations() {
        Iterable<Registration> registrations = registrationService.findAll();

        return registrations;
    }

    @RequestMapping("/{id}")
    public Registration findRegistrationById(@PathVariable("id") Long id) {

        return registrationService.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<?> addRegistration(@RequestBody Registration newRegistration,
                                         UriComponentsBuilder uri) {

        if (newRegistration.getId() != 0 || newRegistration.getNotes() == null
                || newRegistration.getRegistration_date() == null) {
            return ResponseEntity.badRequest().build();
        }
        newRegistration=registrationService.save(newRegistration);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newRegistration.getId()).toUri();
        ResponseEntity<?> response=ResponseEntity.created(location).build();
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putRegistration(@RequestBody Registration newRegistration,
                                         @PathVariable("id") long id) {
        if (newRegistration.getId() != id
                || newRegistration.getNotes() == null
                || newRegistration.getRegistration_date() == null) {
            return ResponseEntity.badRequest().build();
        }
        newRegistration = registrationService.save(newRegistration);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable Long id) {
        registrationService.deleteById(id);
    }


}
