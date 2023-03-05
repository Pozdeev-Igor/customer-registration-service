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
    private User user;


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
    public User getUser() {
        return user;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
