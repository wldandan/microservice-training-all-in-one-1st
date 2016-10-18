package com.example.controller;

import com.example.model.HALResponse;
import com.example.model.Recommendation;
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

@RestController
public class RecommendationController {

    @GetMapping(path = "/", produces = {HAL_JSON_VALUE, APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE})
    public HttpEntity<HALResponse> root() {
        HALResponse halResponse = new HALResponse();
        halResponse.add(new Link(new UriTemplate(linkTo(RecommendationController.class, "").slash("/recommendations").toString() + "{?eventId}"), "recommendations"));
        return new ResponseEntity<>(halResponse, HttpStatus.OK);
    }

    @RequestMapping("/recommendations/{id}")
    public HttpEntity<Recommendation> recommendation(@PathVariable String id) {
        Recommendation recommendation = new Recommendation(id, id, "content " + id);
        recommendation.add(linkTo(methodOn(RecommendationController.class).recommendation(id)).withRel("self"));
        return new ResponseEntity<>(recommendation, HttpStatus.OK);
    }

    @RequestMapping("/recommendations")
    public HttpEntity<HALResponse> recommendations(@RequestParam(value = "eventId") String eventId) {
        HALResponse halResponse = new HALResponse();
        halResponse.add(linkTo(methodOn(RecommendationController.class).recommendations(eventId)).withRel("self"));
        List<Recommendation> recommends = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            String recommendId = String.valueOf(i);
            Recommendation recommendation = new Recommendation(recommendId, recommendId, "content " + i);
            recommendation.add(linkTo(methodOn(RecommendationController.class).recommendation(recommendId)).withRel("self"));
            recommends.add(recommendation);
        }
        halResponse.add("recommendations", recommends);
        return new ResponseEntity<>(halResponse, HttpStatus.OK);
    }
}