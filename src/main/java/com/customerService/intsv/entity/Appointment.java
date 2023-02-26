package com.customerService.intsv.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @ManyToOne
    private ServiceType serviceType;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Barber barber;
    @ManyToOne
    private DayAndTime dayAndTime;
    @OneToOne
    private Feedback feedback;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Barber getBarber() {
        return barber;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public DayAndTime getDayAndTime() {
        return dayAndTime;
    }

    public void setDayAndTime(DayAndTime dayAndTime) {
        this.dayAndTime = dayAndTime;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
}
