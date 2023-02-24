package com.customerService.intsv.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Deposit {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    UUID id;

    @Column(name = "deposit_name")
    String depositName;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;
    @ManyToOne
    @JoinColumn(name = "barber_id")
    Barber barber;

    @Column(name = "money_pool")
    String moneyPool;

    public Client getClient() {
        return client;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDepositName() {
        return depositName;
    }

    public void setDepositName(String depositName) {
        this.depositName = depositName;
    }

    public String getMoneyPool() {
        return moneyPool;
    }

    public void setMoneyPool(String moneyPool) {
        this.moneyPool = moneyPool;
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

}
