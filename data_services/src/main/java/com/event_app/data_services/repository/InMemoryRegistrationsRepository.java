package com.registration_app.data_services.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.registration_app.data_services.model.Registration;
import java.util.Optional;

public class InMemoryRegistrationsRepository {
	
	private List<Registration> RegistrationData = new ArrayList<>(Arrays.asList(
			new Registration( 01L, 101L, 1001L, 04/07/2021, "this is a note"),
			new Registration( 02L, 201L,2001L, 05/17/2021, "also a note")));
		
			
		@Override
		public Registration findById(Long id) {
			Optional<Registration> registrationOptional = registrationData.stream().filter(registration -> registration.getId().equals(id)).findAny();
			
			return registrationOptional.orElse(null);
		}
		
		@Override
		public Collection<Registration> findAll() {
				return Collections.unmodifiableCollection(registrationData);
		}

}
