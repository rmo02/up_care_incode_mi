package com.mirante.upcare.dto.response;

import java.util.UUID;

public record EmpresaResponse(
    UUID idEmpresa,
    String nome,
    String contato
) {}
