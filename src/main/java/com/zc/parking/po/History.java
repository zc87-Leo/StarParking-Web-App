package com.zc.parking.po;


import sun.util.resources.cldr.gv.LocaleNames_gv;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "p_history")
public class History {
    @Id
    @GeneratedValue
    private Long id;
    private Date parkingTime;

    @ManyToOne
    private User user;

    @ManyToOne
    private  Meter meter;

    public History() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(Date parkingTime) {
        this.parkingTime = parkingTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Meter getMeter() {
        return meter;
    }

    public void setMeter(Meter meter) {
        this.meter = meter;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", parkingTime=" + parkingTime +
                '}';
    }
}
