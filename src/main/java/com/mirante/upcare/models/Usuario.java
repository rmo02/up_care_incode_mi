package com.mirante.upcare.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.mirante.upcare.dto.request.LoginRequest;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    private String contato;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_empresa")
    private Empresa empresa;
    // Tipo de usuario: ADMIN, SUPERVISOR, TECNICO
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @NotNull
    @JoinTable(
        name = "Usuario_Role",
        joinColumns =  @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    
    public boolean isLoginCorrect(LoginRequest loginRequest, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(loginRequest.senha(), this.senha);
    }
}
