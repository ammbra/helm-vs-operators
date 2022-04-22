package com.example.socialite.web;

import com.example.socialite.model.Event;
import com.example.socialite.service.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("event")
@RequestScoped
public class EventEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventEndpoint.class);

    @Inject
    private EventRepository repository;

    @GET
      public List<Event> findAll() throws InterruptedException {
        return this.repository.listAll();
    }


    @GET
    @Path("{address}")
    public Response findFirstAddress(@PathParam("address") String address) throws InterruptedException {
        Optional<Event> potentialEvent = repository.findByAddress(address);
        if (potentialEvent.isPresent()) {
            return Response.status(Response.Status.FOUND).entity(potentialEvent.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
