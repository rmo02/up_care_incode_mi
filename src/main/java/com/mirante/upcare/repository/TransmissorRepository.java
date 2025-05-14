package com.mirante.upcare.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirante.upcare.models.Transmissor;

import jakarta.persistence.Entity;

@Entity
public interface TransmissorRepository extends JpaRepository<Transmissor, UUID>    {

    
}
