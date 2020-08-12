package com.event_app.data_services.service;

import com.event_app.data_services.model.Registration;
import java.util.Collection;
import java.util.Optional;

public interface RegistrationService {
	
    Optional<Registration> findById(Long id);
	
	Iterable<Registration> findAll();

}
