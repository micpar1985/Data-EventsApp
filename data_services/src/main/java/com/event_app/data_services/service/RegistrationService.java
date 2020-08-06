package com.event_app.data_services.service;

import com.event_app.data_services.model.Registration;
import java.util.Collection;

public interface RegistrationService {
	
    String findById(Long id);
	
	Collection<Registration> findAll();

}
