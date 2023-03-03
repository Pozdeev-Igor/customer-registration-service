package com.customerService.intsv.repository;

import com.customerService.intsv.entity.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BarberRepository extends JpaRepository<Barber, UUID> {
}
