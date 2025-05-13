package com.mirante.upcare.models;

import java.util.UUID;

import com.mirante.upcare.models.enums.StatusTecnico;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String nome;
    
    @NotNull
    private Float latitude;
    
    @NotNull
    private Float longitude;
    
    @NotBlank
    private String endereco;

    @NotBlank
    private String linkGrafana;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusTecnico status;
}
