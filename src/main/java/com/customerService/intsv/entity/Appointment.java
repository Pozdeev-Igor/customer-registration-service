package com.customerService.intsv.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    UUID id;

    @ManyToOne
    @JoinColumn(name = "service_type_id")
    ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;


    @ManyToOne
    @JoinColumn(name = "barber_id")
    Barber barber;


    @ManyToOne
    @JoinColumn(name = "day_and_time_id_id")
    DayAndTime dayAndTimeId;

    @ManyToOne
    @JoinColumn(name = "feedback_id")
    Feedback feedback;

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

    public DayAndTime getDayAndTimeId() {
        return dayAndTimeId;
    }

    public void setDayAndTimeId(DayAndTime dayAndTimeId) {
        this.dayAndTimeId = dayAndTimeId;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }


}
