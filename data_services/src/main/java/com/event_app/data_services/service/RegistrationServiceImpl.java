package com.event_app.data_services.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;

import com.event_app.data_services.model.Event;
import  com.event_app.data_services.model.Registration;

import com.event_app.data_services.repository.EventsRepository;
import com.event_app.data_services.repository.RegistrationsRepository;
import org.springframework.stereotype.Component;

@Component
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	private RegistrationsRepository registrationsRepository;
	
	@Override
	public Registration findById(Long id) {
		
		return registrationsRepository.findById(id);
	}
	
	@Override 
	public Collection<Registration> findAll(){
		
		return registrationsRepository.findAll();
	}
	
}
