package com.microservice.training.integration;

import com.microservice.training.model.Event;
import com.microservice.training.model.Recommendation;
import com.microservice.training.model.Review;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class EventCompositeIntegration {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private RestOperations restTemplate;

    @HystrixCommand(fallbackMethod = "defaultEvent")
    public Event getEvent(String eventId) {
        return parseEvent(restTemplate.getForEntity(loadBalancer.choose("EVENT").getUri() + "/events/" + eventId, String.class));
    }

    @HystrixCommand(fallbackMethod = "defaultRecommendations")
    public List getRecommendations(String eventId) {
        ResponseEntity<String> resultStr = restTemplate.getForEntity(loadBalancer.choose("RECOMMENDATION").getUri() + "/recommendations?eventId=" + eventId, String.class);
        return parseRecommends(resultStr);
    }

    @HystrixCommand(fallbackMethod = "defaultReviews")
    public List getReviews(String eventId) {
        ResponseEntity<String> resultStr = restTemplate.getForEntity(loadBalancer.choose("REVIEW").getUri() + "/reviews?eventId=" + eventId, String.class);
        return parseReviews(resultStr);
    }

    private Event defaultEvent(String eventId) {
        return new Event(eventId, "默认活动", 0, "", "无介绍", new Date(), new Date());
    }

    private List<Review> defaultReviews(String eventId) {
        return new ArrayList<Review>(){{add(new Review(eventId, "1", "Fallback author", "Fallback subject", "Fallback content"));}};
    }

    private List<Recommendation> defaultRecommendations(String eventId) {
        return new ArrayList<Recommendation>(){{add(new Recommendation(eventId, "1", "Fallback content"));}};
    }

    private Event parseEvent(ResponseEntity<String> resp) {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Event event = null;
        try {
            event = objectMapper.readerFor(Event.class).readValue(resp.getBody());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return event;
    }

    private List parseRecommends(ResponseEntity<String> resp) {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode node = null;
        try {
            node = objectMapper.readerFor(JsonNode.class).readValue(resp.getBody());
            JsonNode jsonNode = node.get("_embedded").get("recommendations");
            return objectMapper.convertValue(jsonNode, List.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List parseReviews(ResponseEntity<String> resp) {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode node = null;
        try {
            node = objectMapper.readerFor(JsonNode.class).readValue(resp.getBody());
            JsonNode jsonNode = node.get("_embedded").get("reviews");
            return objectMapper.convertValue(jsonNode, List.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
