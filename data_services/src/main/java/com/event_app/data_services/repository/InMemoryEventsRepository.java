package com.event_app.data_services.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.event_app.data_services.model.Event;

public class InMemoryEventsRepository implements EventsRepository {

	private List<Event> eventData = new ArrayList<>(Arrays.asList(
		new Event( 01L,"code1", "Sir", "this is a description"),
		new Event( 02L, "code2","Ma'am", "also a description")));
	
		
	@Override
	public Event findById(Long id) {
		Optional<Event> eventOptional = eventData.stream().filter(event -> event.getId().equals(id)).findAny();
		
		return eventOptional.orElse(null);
	}
	
	@Override
	public Collection<Event> findAll() {
			return Collections.unmodifiableCollection(eventData);
	}
	

}


