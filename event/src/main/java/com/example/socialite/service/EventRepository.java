package com.example.socialite.service;

import com.example.socialite.model.Event;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class EventRepository implements PanacheRepository<Event> {

    public Optional<Event> findByAddress(String address) {
        return Optional.ofNullable(find("address like ?1",  "%"+address+"%").firstResult());
    }
}