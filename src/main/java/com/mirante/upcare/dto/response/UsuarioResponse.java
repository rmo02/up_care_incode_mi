package com.mirante.upcare.dto.response;

import java.util.UUID;

public record UsuarioResponse(
    UUID idUsuario,
    String nome,
    String email,
    String senha,
    String contato,
    EmpresaResponse empresa

){}
