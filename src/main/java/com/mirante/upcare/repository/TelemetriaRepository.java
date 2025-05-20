package com.mirante.upcare.repository;

import com.mirante.upcare.models.Telemetria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TelemetriaRepository extends JpaRepository<Telemetria, UUID> {
}
