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

import io.opentracing.Span;
import io.opentracing.Tracer;

@RestController
@RequestMapping("/events")
public class EventsController {

	@Autowired
	EventService eventService;
	
	@Autowired
    private Tracer tracer;

	@RequestMapping
	public Iterable<Event> findAllEvents() {
    	Span span = tracer.buildSpan("Find All Events").start();
    	span.setTag("http.status_code", 200);
		Iterable<Event> events = eventService.findAllEvents();
		
		span.finish();
		return events;
	}

	@RequestMapping("/{id}")
	public ResponseEntity<?> findEventById(@PathVariable("id") Long id) {

		//---- Start Jaeger Span ----//
    	Span span = tracer.buildSpan("Find Event by ID").start();
    	ResponseEntity<?> response;
    	
		try {
			Optional<Event> event = eventService.findByEventId(id);
			response = ResponseEntity.ok(event.get());
			span.setTag("http.status_code",  200);
		} catch (NoSuchElementException e) {
			response = ResponseEntity.notFound().build();
			span.setTag("http.status_code",  404);
		}
		
		//---- Finish Span ----//
		span.finish();
		return response;
	}

	@PostMapping
	public ResponseEntity<?> addEvent(@RequestBody Event newEvent, UriComponentsBuilder uri) {

		//---- Start Jaeger Span ----//
    	Span span = tracer.buildSpan("Add Event").start();
    	ResponseEntity<?> response;
    	
		try {
			if (newEvent.getId() != 0
					|| newEvent.getCode() == null
					|| newEvent.getTitle() == null
					|| newEvent.getDescription() == null) {
				response = ResponseEntity.badRequest().build();
				span.setTag("http.status_code",  400);
				span.finish();
				return response;
			}
			newEvent = eventService.save(newEvent);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newEvent.getId())
					.toUri();
			response = ResponseEntity.created(location).build();
			span.setTag("http.status_code",  201);

		} catch (Exception e) {
			response = ResponseEntity.notFound().build();
			span.setTag("http.status_code",  404);
		}
		
		span.finish();
		return response;
	}

	@PutMapping("/{eventId}")
	public ResponseEntity<?> putEvent(@RequestBody Event newEvent,
									  @PathVariable("eventId") long eventId) {

		//---- Start Jaeger Span ----//
    	Span span = tracer.buildSpan("Edit Event").start();
    	ResponseEntity<?> response;
    	
		try {
			if (newEvent.getId() != eventId
					|| newEvent.getCode() == null
					|| newEvent.getTitle() == null
					|| newEvent.getDescription() == null) {
				response = ResponseEntity.badRequest().build();
				span.setTag("http.status_code",  400);
				span.finish();
				return response;
			}
			newEvent = eventService.save(newEvent);
			response =  ResponseEntity.ok().build();
			span.setTag("http.status_code",  200);
		} catch (Exception e) {
			response = ResponseEntity.notFound().build();
			span.setTag("http.status_code",  404);
		}
		span.finish();
		return response;
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEvent(@PathVariable Long id) {

		//---- Start Jaeger Span ----//
    	Span span = tracer.buildSpan("Delete Event").start();
    	ResponseEntity<?> response;
    	
		try {
			eventService.deleteById(id);
			response = ResponseEntity.noContent().build();
			span.setTag("http.status_code",  204);
		} catch (EmptyResultDataAccessException e) {
			response =  ResponseEntity.notFound().build();
			span.setTag("http.status_code", 404);
		}
		span.finish();
		return response;

	}
}
