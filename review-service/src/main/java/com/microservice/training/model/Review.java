package com.microservice.training.model;

import org.springframework.hateoas.ResourceSupport;

public class Review extends ResourceSupport {
    private String eventId;
    private String reviewId;
    private String author;
    private String subject;
    private String content;

    public Review() {}

    public Review(String eventId, String reviewId, String author, String subject, String content) {
        this.eventId = eventId;
        this.reviewId = reviewId;
        this.author = author;
        this.subject = subject;
        this.content = content;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
