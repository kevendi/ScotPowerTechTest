package com.scotpower.api.smart.reads;

import com.scotpower.api.model.Gas;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class ReadsTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testInsertingUser() {
        HttpRequest request = HttpRequest.POST("api/smart/reads/insert_user", "");
        HttpResponse response = client.toBlocking().exchange(request);

        assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    void testInsertingReading() {
        HttpRequest request = HttpRequest.POST("api/smart/reads/insert_reading", "");
        HttpResponse response = client.toBlocking().exchange(request);

        assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    void testRetrievingGasReading() {
        HttpRequest getReading = HttpRequest.GET("api/smart/reads/get/4563");
        HttpResponse getReadingResponse = client.toBlocking().exchange(getReading);

        assertEquals(HttpStatus.OK, getReadingResponse.getStatus());
    }

    @Test
    void testRetrievingUsers() {
        // insert user
        HttpRequest.POST("api/smart/reads/insert_user", "");

        HttpRequest getUser = HttpRequest.GET("api/smart/reads/user/4563");
        HttpResponse getUserResponse = client.toBlocking().exchange(getUser);

        assertEquals(HttpStatus.OK, getUserResponse.getStatus());
    }


}
