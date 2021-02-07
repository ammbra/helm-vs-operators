package com.example.socialite;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class EventEndpointTest {

    @Test
    public void getAll() {
        given()
                .when().get("/api/event")
                .then()
                .body(notNullValue());
    }

}