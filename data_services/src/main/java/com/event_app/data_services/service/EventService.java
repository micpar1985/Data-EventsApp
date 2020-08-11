package com.event_app.data_services.service;

import java.util.Collection;
import com.event_app.data_services.model.Event;


public interface EventService {
	
	Event findByEventId(Long id);
	
	Collection<Event> findAllEvents();
	
}
