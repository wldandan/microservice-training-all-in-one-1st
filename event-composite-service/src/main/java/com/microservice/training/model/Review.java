package com.microservice.training.model;

public class Review {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (eventId != null ? !eventId.equals(review.eventId) : review.eventId != null) return false;
        if (reviewId != null ? !reviewId.equals(review.reviewId) : review.reviewId != null) return false;
        if (author != null ? !author.equals(review.author) : review.author != null) return false;
        if (subject != null ? !subject.equals(review.subject) : review.subject != null) return false;
        return content != null ? content.equals(review.content) : review.content == null;

    }

    @Override
    public int hashCode() {
        int result = eventId != null ? eventId.hashCode() : 0;
        result = 31 * result + (reviewId != null ? reviewId.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
