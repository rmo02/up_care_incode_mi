package com.mirante.upcare.repository;

import com.mirante.upcare.models.Quadro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuadroRepository extends JpaRepository<Quadro, UUID> {
}
