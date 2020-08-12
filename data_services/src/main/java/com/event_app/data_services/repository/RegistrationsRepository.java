package com.event_app.data_services.repository;

import java.util.Collection;
import java.util.Optional;

import com.event_app.data_services.model.Registration;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationsRepository extends CrudRepository<Registration, Long> {

	/*public Optional<Registration> findById(Long id);
	
	public Collection<Registration> findAll();*/

}
