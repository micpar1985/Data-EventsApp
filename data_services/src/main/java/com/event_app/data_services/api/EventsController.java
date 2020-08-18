package com.event_app.data_services.api;

import java.net.URI;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import com.event_app.data_services.model.Event;
import com.event_app.data_services.repository.EventsRepository;
import com.event_app.data_services.service.EventService;


@RestController
@RequestMapping("/events")
public class EventsController {

	@Autowired
	EventService eventService;

	@Autowired
	EventsRepository repo;

	@RequestMapping
	public Iterable<Event> findAllEvents() {
		Iterable<Event> events = eventService.findAllEvents();

		return events;
	}

	@RequestMapping("/{id}")
	public Event findEventById(@PathVariable("id") Long id) {
		return eventService.findByEventId(id).get();
	}

	@GetMapping
	public Iterable<Event> getAll() {
		return repo.findAll();
	}

	@GetMapping("/{eventId}")
	public Optional<Event> getEventById(@PathVariable("eventId") long id) {
		return repo.findById(id);
	}

	@PostMapping
	public ResponseEntity<?> addEvent(@RequestBody Event newEvent, UriComponentsBuilder uri) {
		if (newEvent.getId() != 0 
				|| newEvent.getCode() == null 
				|| newEvent.getTitle() == null
				|| newEvent.getDescription() == null) {// Reject - we'll assign the Event id
			return ResponseEntity.badRequest().build();
		}
		newEvent = repo.save(newEvent);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newEvent.getId())
				.toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}

	@PutMapping("/{eventId}")
	public ResponseEntity<?> putEvent(@RequestBody Event newEvent,
			@PathVariable("eventId") long eventId) {
		if (newEvent.getId() != eventId 
				|| newEvent.getCode() == null 
				|| newEvent.getTitle() == null 
				|| newEvent.getDescription()== null) {
			return ResponseEntity.badRequest().build();
		}
		newEvent = eventService.save(newEvent);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public void deleteEvent(@PathVariable Long id) {
		eventService.deleteById(id);
	}

}
