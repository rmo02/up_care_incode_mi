package com.mirante.upcare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mirante.upcare.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>  {
    Optional<Role> findByNome(String nome); 
}
