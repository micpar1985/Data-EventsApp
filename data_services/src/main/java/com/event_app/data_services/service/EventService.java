package com.event_app.data_services.service;

import java.util.Collection;
import java.util.Optional;

import com.event_app.data_services.model.Event;


public interface EventService {
	
	Optional<Event> findByEventId(Long id);
	
	Iterable<Event> findAllEvents();
	
}
