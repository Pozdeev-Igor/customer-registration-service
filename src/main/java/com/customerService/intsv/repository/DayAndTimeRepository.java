package com.customerService.intsv.repository;

import com.customerService.intsv.entity.DayAndTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DayAndTimeRepository extends JpaRepository<DayAndTime, UUID> {
}
