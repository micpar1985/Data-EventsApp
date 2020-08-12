package com.event_app.data_services.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.event_app.data_services.model.Event;
import com.event_app.data_services.repository.EventsRepository;
import org.springframework.stereotype.Component;

@Component
public class EventServiceImpl implements EventService{


	@Autowired
	private EventsRepository eventsRepository;

	@Override
	public Optional<Event> findByEventId(Long id) {
		return eventsRepository.findById(id);
	}

	@Override
	public Iterable<Event> findAllEvents(){
		
		return eventsRepository.findAll();
	}

	@Override
	public void saveEvent(Event event) {
		eventsRepository.save(event);
		
	}
}
