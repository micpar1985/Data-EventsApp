package com.event_app.data_services.api;

import com.event_app.data_services.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
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
        Collection<Event> events = eventService.findAll();

        return events;

    }


}
