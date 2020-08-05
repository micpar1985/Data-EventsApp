package com.event_app.data_services.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventsController {

    @RequestMapping
    public Collection<Event> findAllEvents() {
        Collection<Event> events = eventService.findAll();

        return events;

    }


}
