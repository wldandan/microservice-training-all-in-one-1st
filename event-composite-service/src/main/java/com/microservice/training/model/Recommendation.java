package com.microservice.training.model;

public class Recommendation {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recommendation that = (Recommendation) o;

        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;
        if (recommendationId != null ? !recommendationId.equals(that.recommendationId) : that.recommendationId != null)
            return false;
        return content != null ? content.equals(that.content) : that.content == null;

    }

    @Override
    public int hashCode() {
        int result = eventId != null ? eventId.hashCode() : 0;
        result = 31 * result + (recommendationId != null ? recommendationId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
