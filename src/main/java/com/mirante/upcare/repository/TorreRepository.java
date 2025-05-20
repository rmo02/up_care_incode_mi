package com.mirante.upcare.repository;

import com.mirante.upcare.models.Torre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TorreRepository extends JpaRepository<Torre, UUID> {
}
