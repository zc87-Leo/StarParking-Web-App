package com.zc.parking.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "p_meter")
public class Meter {
    @Id
    @GeneratedValue
    private Long id;
    private Double longitude;
    private Double latitude;
    private String street;
    private Integer payPolicy;
    private Integer availability;

@OneToMany(mappedBy = "meter")
private List<Comment> comments= new ArrayList<>();

@ManyToMany(mappedBy = "meters")
private List<User> users = new ArrayList<>();

@OneToMany(mappedBy = "meter")
private List<History> histories= new ArrayList<>();

    public Meter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getPayPolicy() {
        return payPolicy;
    }

    public void setPayPolicy(Integer payPolicy) {
        this.payPolicy = payPolicy;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories1) {
        this.histories = histories;
    }

    @Override
    public String toString() {
        return "Meter{" +
                "id=" + id +
                ", longtitude=" + longitude +
                ", latitude=" + latitude +
                ", street='" + street + '\'' +
                ", payPolicy=" + payPolicy +
                ", availability=" + availability +
                '}';
    }
}
