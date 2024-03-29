package com.example.landmark.web;

import com.example.landmark.model.Location;
import com.example.landmark.service.LocationRepository;
import com.example.landmark.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.Produces;


@Path("landmark")
public class LocationEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationEndpoint.class);

    @Inject
    private LocationRepository repository;

    @GET
    public List<Location> findAll() throws InterruptedException {
        return repository.listAll();
    }

}
