package com.customerService.intsv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
@Builder
public class User implements UserDetails {

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
    @Column(name = "amount")
    private String amount;
    @Column(name = "rate")
    private Float rate;
    @Column(name = "birth_date")
    private String birthDate;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @JsonIgnore
    private List<Authority> authorities = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "barber_can_serve",
            joinColumns = { @JoinColumn(name = "barber_id") },
            inverseJoinColumns = { @JoinColumn(name = "can_serve_id") })
    private Set<ServiceType> canServe;

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

    @Override
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public Set<ServiceType> getCanServe() {
        return canServe;
    }

    public void setCanServe(Set<ServiceType> canServe) {
        this.canServe = canServe;
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

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @Override
    public String getUsername() {
        return phoneNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
