package com.event_app.data_services.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registrations")
public class RegistrationsController {

    @RequestMapping
    public Collection<Registration> findAllRegistrations() {
        Collection<Registration> registrations = registrationService.findAll();
        
        return registrations;

    }


}
