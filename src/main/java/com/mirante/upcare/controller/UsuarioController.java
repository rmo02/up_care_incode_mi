package com.mirante.upcare.controller;

import com.mirante.upcare.dto.request.UsuarioRequest;
import com.mirante.upcare.dto.response.UsuarioResponse;
import com.mirante.upcare.mappers.UsuarioMapper;
import com.mirante.upcare.models.Usuario;
import com.mirante.upcare.service.UsuarioService;
import com.mirante.upcare.utils.Pipeline;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("Usuario")
public class UsuarioController {

    private UsuarioService usuarioService;
    private UsuarioMapper usuarioMapper;

    @PostMapping
    public ResponseEntity<UUID> salvar(@RequestBody @Valid UsuarioRequest dto){
        return (Pipeline
                .from(dto)
                .then(usuarioMapper::toEntity)
                .then(usuarioService::salvar)
                .then(Usuario::getId)
                .then(id-> ResponseEntity.status(HttpStatus.CREATED).body(id))
                .get()
        );
    }
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> buscarTodos(){
        return (Pipeline
                .from(usuarioService.buscarTodos())
                .then(usuarioMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get()
        );
    }

    @GetMapping("{idUsuario}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable UUID idUsuario) {
        return (Pipeline
                .from(idUsuario)
                .then(usuarioService::buscarPorId)
                .then(usuarioMapper::toResponse)
                .then(ResponseEntity::ok)
                .get()
        );
    }
    @DeleteMapping("{idUsuario}")
    public ResponseEntity<Void> deletarPorId(@PathVariable UUID idUsuario) {
        usuarioService.deletarPorId(idUsuario);
        return ResponseEntity.ok().build();
    }


}
