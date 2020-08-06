package com.event_app.data_services.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.springframework.stereotype.Component;
import com.event_app.data_services.model.Registration;


@Component
public class InMemoryRegistrationsRepository implements RegistrationsRepository {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private List<Registration> registrationData = new ArrayList<>(Arrays.asList(
			new Registration( 01L, 101L, 1001L, parseDate("2021-04-07"), "this is a note"),
			new Registration( 02L, 201L,2001L, parseDate("2021-05-17"), "also a note")));

	@Override
		public String findById(Long id) {
			Optional<Registration> registrationOptional = registrationData.stream().filter(registration -> registration.getId().equals(id)).findAny();
			
			return registrationOptional.map(Registration::toString).orElse(null);
		}
		
		@Override
		public Collection<Registration> findAll() {
				return Collections.unmodifiableCollection(registrationData);
		}

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}


}
