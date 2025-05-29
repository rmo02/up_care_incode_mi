package com.mirante.upcare.dto.request;

import jakarta.validation.constraints.NotBlank;

public record EmpresaRequest(
        @NotBlank
        String nome,

        @NotBlank
        String contato
) {
}
