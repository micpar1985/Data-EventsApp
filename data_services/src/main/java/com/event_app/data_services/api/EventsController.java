package com.event_app.data_services.api;

import java.net.URI;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.event_app.data_services.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

	@RequestMapping
	public Iterable<Event> findAllEvents() {
		Iterable<Event> events = eventService.findAllEvents();
		return events;  //this one is probably fine
	}

	@RequestMapping("/{id}")
	public ResponseEntity<?> findEventById(@PathVariable("id") Long id) {

		try {
			Optional<Event> event = eventService.findByEventId(id);
			ResponseEntity<?> response;
			response = ResponseEntity.ok(event.get());
			return response;
		} catch (NoSuchElementException e) {
			ResponseEntity<?> response = ResponseEntity.notFound().build();
			return response;
		}
	}

	@PostMapping
	public ResponseEntity<?> addEvent(@RequestBody Event newEvent, UriComponentsBuilder uri) {

		try {
			if (newEvent.getId() != 0
					|| newEvent.getCode() == null
					|| newEvent.getTitle() == null
					|| newEvent.getDescription() == null) {
				return ResponseEntity.notFound().build();

			}
			newEvent = eventService.save(newEvent);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newEvent.getId())
					.toUri();
			ResponseEntity<?> response = ResponseEntity.created(location).build();
			return response;

		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{eventId}")
	public ResponseEntity<?> putEvent(@RequestBody Event newEvent,
									  @PathVariable("eventId") long eventId) {

		try {
			if (newEvent.getId() != eventId
					|| newEvent.getCode() == null
					|| newEvent.getTitle() == null
					|| newEvent.getDescription() == null) {
				return ResponseEntity.notFound().build();
			}
			newEvent = eventService.save(newEvent);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEvent(@PathVariable Long id) {

		try {
			eventService.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}

	}
}
