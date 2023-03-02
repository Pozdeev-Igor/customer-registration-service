package com.customerService.intsv.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import java.util.UUID;

@Entity
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "authority")
    private String authority;
    @ManyToOne(optional = false)
    private Client client;
    @ManyToOne(optional = false)
    private Barber barber;


    public Authority() {
    }
    public Authority(String authority) {
        this.authority = authority;
    }


    @Override
    public String getAuthority() {
        return authority;
    }

    public UUID getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Barber getBarber() {
        return barber;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }
}
