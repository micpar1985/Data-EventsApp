package com.event_app.data_services.service;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;

import com.event_app.data_services.model.Event;

import com.event_app.data_services.repository.EventsRepository;

public class EventServiceImpl implements EventService{


	@Autowired
	private EventsRepository eventsRepository;
	
	@Override 
	public Event findByIdEvent(Long id) {
		
		return eventsRepository.findByIdEvent(id);
		
	}
	
	@Override 
	public Collection<Event> findAllEvents(){
		
		return eventsRepository.findAllEvents();
	}
}
