package com.customerService.intsv.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
public class Barber {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "rate")
    private Float rate;
    @Column(name = "amount")
    private String amount;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "barber_can_serve",
            joinColumns = { @JoinColumn(name = "barber_id") },
            inverseJoinColumns = { @JoinColumn(name = "can_serve_id") })
    private Set<ServiceType> canServe;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deposit_id", referencedColumnName = "id")
    private Deposit deposit;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "barber_weekends",
                joinColumns = {@JoinColumn(name = "barber_id")},
                inverseJoinColumns = {@JoinColumn(name = "day_and_time_id")}
    )
    private List<DayAndTime> weekends;
    @Column(name = "is_active")
    private Boolean isActive;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Set<ServiceType> getCanServe() {
        return canServe;
    }

    public void setCanServe(Set<ServiceType> canServe) {
        this.canServe = canServe;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public List<DayAndTime> getWeekends() {
        return weekends;
    }

    public void setWeekends(List<DayAndTime> weekends) {
        this.weekends = weekends;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
