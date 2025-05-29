package com.mirante.upcare.models;

import java.util.UUID;

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
}
