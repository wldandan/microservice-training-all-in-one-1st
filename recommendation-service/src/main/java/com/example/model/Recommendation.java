package com.example.model;

import org.springframework.hateoas.ResourceSupport;

public class Recommendation extends ResourceSupport {
    private String eventId;
    private String recommendationId;
    private String content;

    public Recommendation() {}

    public Recommendation(String eventId, String recommendationId, String content) {
        this.eventId = eventId;
        this.recommendationId = recommendationId;
        this.content = content;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(String recommendationId) {
        this.recommendationId = recommendationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
