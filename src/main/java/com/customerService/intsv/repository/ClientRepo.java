package com.customerService.intsv.repository;

import com.customerService.intsv.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepo extends JpaRepository<Client, UUID> {
    Client findByAmount(String s);
}
