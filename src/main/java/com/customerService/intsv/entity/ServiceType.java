package com.customerService.intsv.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class ServiceType {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    UUID id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @OneToMany
    Set<Feedback> feedbackSet;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Feedback> getFeedbackSet() {
        return feedbackSet;
    }

    public void setFeedbackSet(Set<Feedback> feedbackSet) {
        this.feedbackSet = feedbackSet;
    }

    public Set<Barber> getBarbers() {
        return barbers;
    }

    public void setBarbers(Set<Barber> barbers) {
        this.barbers = barbers;
    }

    @ManyToMany
    @JoinTable(name = "ServiceType_barber",
            joinColumns = @JoinColumn(name = "serviceType_id")
            ,inverseJoinColumns = @JoinColumn(name = "barber_id"))
    private Set<Barber> barbers = new LinkedHashSet<>();


}
