package com.event_app.data_services.service;

import java.util.Collection;
import java.util.Optional;

import com.event_app.data_services.model.Event;


public interface EventService {
	
	public Optional<Event> findByEventId(Long id);
	
	public Iterable<Event> findAllEvents();
	
	public void saveEvent(Event event);
	
}
