package com.example.landmark.service;

import com.example.landmark.model.Location;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class LocationRepository implements PanacheRepository<Location> {

    public Optional<Location> findByAddress(String address) {
        return Optional.ofNullable(find("address like ?1",  "%"+address+"%").firstResult());
    }
}