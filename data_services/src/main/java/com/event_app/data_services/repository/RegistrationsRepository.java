package com.event_app.data_services.repository;

import com.event_app.data_services.model.Registration;
import org.springframework.data.repository.CrudRepository;


public interface RegistrationsRepository extends CrudRepository<Registration, Long> {}
