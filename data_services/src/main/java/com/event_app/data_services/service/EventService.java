package com.event_app.data_services.service;

import java.util.Collection;
import com.event_app.data_services.model.Event;


public interface EventService {
	
	public Event findByIdEvent(Long id);
	
	public Collection<Event> findAllEvents();
	
}
