package com.microservice.training.controller;

import com.microservice.training.integration.EventCompositeIntegration;
import com.microservice.training.hal.HALResponse;
import com.microservice.training.model.Event;
import com.microservice.training.model.EventAggregated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.UriTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class EventCompositeController {

    @Autowired
    private EventCompositeIntegration integration;

    @GetMapping(path = "/", produces = {HAL_JSON_VALUE, APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE})
    public HttpEntity<HALResponse> root() {
        HALResponse halResponse = new HALResponse();
        halResponse.add(new Link(new UriTemplate(linkTo(EventCompositeController.class, "").toString() + "/{eventId}"), "event"));
        return new ResponseEntity<>(halResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/events/{eventId}", produces = {HAL_JSON_VALUE, APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<EventAggregated> getProduct(@PathVariable String eventId) {
        Event event = integration.getEvent(eventId);
        List recommendations = integration.getRecommendations(eventId);
        List reviews = integration.getReviews(eventId);

        EventAggregated eventAggregated = new EventAggregated(event, recommendations, reviews);
        eventAggregated.add(new Link(new UriTemplate(linkTo(EventCompositeController.class, "").slash(eventId).toString()), "self"));
        
        return new ResponseEntity<>(eventAggregated, HttpStatus.OK);
    }
}
