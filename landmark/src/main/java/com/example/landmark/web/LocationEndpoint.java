package com.example.landmark.web;

import com.example.landmark.model.Location;
import com.example.landmark.service.LocationService;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

@Path("landmark")
@RequestScoped
public class LocationEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationEndpoint.class);

    @Inject
    private LocationService locationService;

    @Timeout(value = 2, unit = ChronoUnit.SECONDS)
    @Retry(maxRetries = 2, maxDuration = 2000)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
      public List<Location> findAll() throws InterruptedException {
        return this.locationService.getAll();
    }

}
