package com.mirante.upcare.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TransmissorRequest(
    @NotNull
    EquipamentoRequest equipamento,

    @NotBlank
    String programado,

    @NotNull 
    Float canalFisico,

    @NotNull 
    Float canalVirtual,

    @NotNull 
    Float acopladorUm ,

    @NotNull 
    Float acopladorDois

){}

