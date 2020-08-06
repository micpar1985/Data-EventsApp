package com.event_app.data_services.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import com.event_app.data_services.model.Event;
import com.event_app.data_services.repository.EventsRepository;

public class EventServiceImpl implements EventService{


	@Autowired
	private EventsRepository eventsRepository;

	@Override
	public Event findByEventId(Long id) {
		return eventsRepository.findByEventId(id);
	}

	@Override
	public Collection<Event> findAllEvents(){
		
		return eventsRepository.findAll();
	}
}
