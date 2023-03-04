package com.customerService.intsv.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import java.util.UUID;

@Entity
public class DayAndTime { //RecordingDate
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "starts_from")
    private Long startingFrom;
    @Column(name = "ends_with")
    private Long endingTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getStartingFrom() {
        return startingFrom;
    }

    public void setStartingFrom(Long from) {
        this.startingFrom = from;
    }

    public Long getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Long to) {
        this.endingTime = to;
    }
}
