package com.mirante.upcare.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UsuarioRequest(

        @NotBlank
        String nome,

        @NotBlank
        String email,

        @NotBlank
        String senha,

        @NotBlank
        String contato,

        @NotNull
        UUID idEmpresa

){}
