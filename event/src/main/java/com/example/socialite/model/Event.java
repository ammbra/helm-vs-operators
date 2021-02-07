package com.example.socialite.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Entity
public class Event extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String address;
    private String city;
    private String country;
    private Integer rating;
    private Double price;
    private Integer discount;
    private String duration;

    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date scheduled;

}
