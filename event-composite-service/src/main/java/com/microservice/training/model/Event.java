package com.microservice.training.model;

import java.util.Date;

public class Event {
    private String id;

    private String name;
    private Integer numberLimit;
    private String mainPhoto;
    private String introduction;

    private Date startAt;
    private Date endAt;

    public Event() {}

    public Event(String id, String name, Integer numberLimit, String mainPhoto, String introduction, Date startAt, Date endAt) {
        this.id = id;
        this.name = name;
        this.numberLimit = numberLimit;
        this.mainPhoto = mainPhoto;
        this.introduction = introduction;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberLimit() {
        return numberLimit;
    }

    public void setNumberLimit(Integer numberLimit) {
        this.numberLimit = numberLimit;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }
}
