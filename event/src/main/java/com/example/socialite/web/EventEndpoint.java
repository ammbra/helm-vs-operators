package com.example.socialite.web;

import com.example.socialite.model.Event;
import com.example.socialite.service.EventService;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Path("event")
@RequestScoped
public class EventEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventEndpoint.class);

    @Inject
    private EventService eventService;

    @Timeout(value = 2, unit = ChronoUnit.SECONDS)
    @Retry(maxRetries = 2, maxDuration = 2000)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
      public List<Event> findAll() throws InterruptedException {
        return this.eventService.getAll();
    }

}
