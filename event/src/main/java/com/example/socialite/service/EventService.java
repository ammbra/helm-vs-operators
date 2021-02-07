package com.example.socialite.service;

import com.example.socialite.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class EventService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventService.class);

    @Inject
    EventRepository repository;

    public List<Event> getAll() {
        return repository.listAll();
    }
}


