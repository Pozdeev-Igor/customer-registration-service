package com.customerService.intsv.entity;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.UUID;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @ManyToOne
//    @Column(name = "service_type_id")
    private ServiceType serviceType;
    @ManyToOne
//    @Column(name = "client_id")
    private Client client;
    @ManyToOne
//    @Column(name = "barber_id")
    private Barber barber;
    @ManyToOne
//    @Column(name = "day_and_time_id")
    private DayAndTime dayAndTime;
    @OneToOne
//    @Column(name = "feedback_id")
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
