package com.example.landmark.service;

import com.example.landmark.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class LocationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationService.class);

    @Inject
    LocationRepository repository;

    public List<Location> getAll() {
        return repository.listAll();
    }
}


