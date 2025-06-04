package com.mirante.upcare.dto.request;

import com.mirante.upcare.models.enums.StatusTecnico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EstacaoRequest(
    @NotBlank
    String nome,
    
    @NotNull
    Float latitude,
    
    @NotNull
    Float longitude,
    
    @NotBlank
    String endereco,

    @NotBlank
    String linkGrafana,

    @NotNull
    StatusTecnico status
) {}
