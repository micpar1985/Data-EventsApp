package com.event_app.data_services.service;

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
	public Event save(Event event) {
		return eventsRepository.save(event);
	}

	@Override
	public void deleteById(Long id) {
		eventsRepository.deleteById(id);
	}
}
