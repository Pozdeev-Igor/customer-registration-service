package com.customerService.intsv.repository;

import com.customerService.intsv.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,UUID> {
}
