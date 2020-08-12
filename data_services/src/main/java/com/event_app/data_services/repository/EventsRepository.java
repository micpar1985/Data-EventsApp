package com.event_app.data_services.repository;

import java.util.Collection;
import java.util.Optional;

import com.event_app.data_services.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventsRepository extends CrudRepository<Event, Long> {

	public Optional<Event> findById(Long id);
	
	public Collection<Event> findAll();

}
