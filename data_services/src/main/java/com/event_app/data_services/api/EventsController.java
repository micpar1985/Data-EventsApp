package com.event_app.data_services.api;

import com.event_app.data_services.model.Event;
import com.event_app.data_services.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    EventService eventService;

    @RequestMapping
    public Collection<Event> findAllEvents() {
        Collection<Event> events = eventService.findAllEvents();

        return events;
    }

    @RequestMapping("/{id}")
    public String findEventById(@PathVariable("id") Long id) {
        return eventService.findByEventId(id);
    }

    @RequestMapping("/{name}")
    public String findEventByName(@PathVariable("name") String name) {
        return eventService.findByEventName(name);
    }





}
