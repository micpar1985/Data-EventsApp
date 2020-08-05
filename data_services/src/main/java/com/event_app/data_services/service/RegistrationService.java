package com.event_app.data_services.service;

import com.event_app.data_services.model.Registration;

public interface RegistrationService {
	
    public Registration findById(Long id);
	
	public Collection<Registration> findAll();

}
