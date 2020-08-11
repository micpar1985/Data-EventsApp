package com.event_app.data_services.api;

import com.event_app.data_services.model.Registration;
import com.event_app.data_services.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/registrations")
public class RegistrationsController {

    @Autowired
    RegistrationService registrationService;

    @RequestMapping
    public Collection<Registration> findAllRegistrations() {
        Collection<Registration> registrations = registrationService.findAll();

        return registrations;
    }

    @RequestMapping("/{id}")
    public Registration findRegistrationById(@PathVariable("id") Long id) {

        return registrationService.findById(id);
    }


}
