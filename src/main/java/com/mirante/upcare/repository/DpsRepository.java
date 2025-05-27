package com.mirante.upcare.repository;

import com.mirante.upcare.models.Dps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DpsRepository extends JpaRepository<Dps, UUID> {
}
