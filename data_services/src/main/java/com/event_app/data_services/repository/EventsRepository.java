package com.event_app.data_services.repository;

import com.event_app.data_services.model.Event;
import org.springframework.data.repository.CrudRepository;


public interface EventsRepository extends CrudRepository<Event, Long> {}
