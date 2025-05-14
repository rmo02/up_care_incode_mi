package com.mirante.upcare.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirante.upcare.models.Receptor;

import jakarta.persistence.Entity;

@Entity
public interface ReceptorRepository extends JpaRepository<Receptor, UUID>  {

    
}
