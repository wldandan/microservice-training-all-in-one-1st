package com.microservice.training.controller;

import com.microservice.training.hal.HALResponse;
import com.microservice.training.model.Review;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.UriTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;
import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class ReviewController {
    private static final Logger LOG = LoggerFactory.getLogger(ReviewController.class);

    @GetMapping(path = "/", produces = {HAL_JSON_VALUE, APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE})
    public HttpEntity<HALResponse> root() {
        HALResponse halResponse = new HALResponse();
        halResponse.add(new Link(new UriTemplate(linkTo(ReviewController.class, "").slash("/reviews").toString() + "{?eventId}"), "reviews"));
        return new ResponseEntity<>(halResponse, HttpStatus.OK);
    }

    @RequestMapping("/reviews/{id}")
    public HttpEntity<Review> review(@PathVariable String id) {
        Review review = new Review(id, id, "author " + id, "subject " + id, "content " + id);
        review.add(linkTo(methodOn(ReviewController.class).review(id)).withRel("self"));
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @RequestMapping("/reviews")
    public HttpEntity<HALResponse> reviews(@RequestParam(value = "eventId") String eventId) {
        HALResponse halResponse = new HALResponse();
        halResponse.add(linkTo(methodOn(ReviewController.class).reviews(eventId)).withRel("self"));
        List<Review> reviews = new ArrayList<Review>();
        for (int i = 1; i < 4; i++) {
            Review review = new Review(eventId, String.valueOf(i), "author " + i, "subject " + i, "content " + i);
            review.add(linkTo(methodOn(ReviewController.class).review(String.valueOf(i))).withRel("self"));
            reviews.add(review);
        }
        halResponse.add("reviews", reviews);
        return new ResponseEntity<>(halResponse, HttpStatus.OK);
    }

}
