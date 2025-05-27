package com.mirante.upcare.repository;

import com.mirante.upcare.models.Nobreak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NobreakRepository extends JpaRepository<Nobreak, UUID> {
}
