package com.mirante.upcare.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mirante.upcare.models.Parabolica;

@Repository
public interface ParabolicaRepository extends JpaRepository<Parabolica, UUID> {

    
}
