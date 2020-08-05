package com.event_app.data_services.repository;

import java.util.Collection;

import com.event_app.data_services.model.Event;

public interface EventsRepository {

	public Event findById(Long id);
	
	public Collection<Event> findAll();
	
	//public Collection<Event> findByName(String name);
	
	//public long count();
	
	//public Event save(Event event);
	
	//public void delete(Event event);
	
}
