package com.registration_app.data_services.repository;

import java.util.Collection;

import com.registration_app.data_services.model.Registration;

public interface RegistrationsRepository {


	public Registration findById(Long id);
	
	public Collection<Registration> findAll();
	
	//public Collection<Registration> findByName(String name);
	
	//public long count();
	
	//public Registration save(Registration registration);
	
	//public void delete(Registration registration);
	
}
