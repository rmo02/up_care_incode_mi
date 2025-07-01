package com.mirante.upcare.controller;

import java.util.List;
import java.util.UUID;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirante.upcare.dto.request.UsuarioRequest;
import com.mirante.upcare.dto.response.UsuarioResponse;
import com.mirante.upcare.mappers.UsuarioMapper;
import com.mirante.upcare.service.UsuarioService;
import com.mirante.upcare.utils.Pipeline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @Operation(
            summary = "Criar um novo usuarios",
            description = "Cria e salva um novo usuarios com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<Object> salvar(
            @Parameter(description = "Dados do novo usuarios", required = true)
            @RequestBody @Valid UsuarioRequest dto){
        return (Pipeline
            .from(dto)
            .then(usuarioMapper::toEntity)
            .then(usuarioService::salvar)
            .then(u -> ResponseEntity.status(HttpStatus.CREATED).build())
            .get()
        );
    }

    @Operation(
            summary = "Buscar todos os usuarios",
            description = "Retorna todos os usuarios cadastrados no sistema"
    )
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> buscarTodos(){
        return (Pipeline
            .from(usuarioService.buscarTodos())
            .then(usuarioMapper::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @Operation(
            summary = "Buscar usuarios por ID",
            description = "Retorna os dados de um usuarios específico com base no ID fornecido"
    )
    @GetMapping("{idUsuario}")
    public ResponseEntity<UsuarioResponse> buscarPorId(
            @Parameter(description = "ID do usuarios a ser buscado", required = true)
            @PathVariable UUID idUsuario) {
        return (Pipeline
            .from(idUsuario)
            .then(usuarioService::buscarPorId)
            .then(usuarioMapper::toResponse)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @Operation(
            summary = "Atualizar usuarios por ID",
            description = "Atualiza os dados de um usuarios existente com base no ID e nos dados fornecidos"
    )
    @PutMapping("{idUsuario}")
    public ResponseEntity<Object> atualizarPorId(
            @Parameter(description = "ID do usuarios a ser atualizado", required = true)
            @PathVariable UUID idUsuario,
            @Parameter(description = "Novos dados do usuarios",required = true)
            @Valid @RequestBody UsuarioRequest dto) {
        return (Pipeline
            .from(dto)
            .then(usuarioMapper::toEntity)
            .then(usuarioAtualizado -> usuarioService.atualizarPorId(idUsuario, usuarioAtualizado))
            .then(u -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @Operation(
            summary = "Excluir usuarios por ID",
            description = "Remove um usuarios existente com base no ID fornecido"
    )
    @DeleteMapping("{idUsuario}")
    public ResponseEntity<Object> deletarPorId(
            @Parameter(description = "ID do usuarios a ser excluido",required = true)
            @PathVariable UUID idUsuario) {
        usuarioService.deletarPorId(idUsuario);
        return ResponseEntity.noContent().build();
    }
}
