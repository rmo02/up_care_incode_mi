package com.mirante.upcare.controller;

import java.time.Instant;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirante.upcare.dto.request.LoginRequest;
import com.mirante.upcare.dto.response.LoginResponse;
import com.mirante.upcare.models.Role;
import com.mirante.upcare.repository.UsuarioRepository;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TokenController {
    
    private final JwtEncoder jwtEncoder;
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public TokenController(JwtEncoder jwtEncoder, UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtEncoder = jwtEncoder;
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
    
       var usuario = usuarioRepository.findByNome(loginRequest.usuario());
       if (usuario.isEmpty() || !usuario.get().isLoginCorrect(loginRequest, bCryptPasswordEncoder)) {
        throw new BadCredentialsException("Falha na autenticação. Verifique seus dados.");
       }

       var now = Instant.now();
       var expiraEm = 300L;

       var escopos = usuario.get().getRoles()
                .stream()
                .map(Role::getNome)
                .collect(Collectors.joining(" "));

       var claims = JwtClaimsSet.builder()
            .issuer("backend")
            .subject(usuario.get().getId().toString())
            .issuedAt(now)
            .expiresAt(now.plusSeconds(expiraEm))
            .claim("scope", escopos)
            .build();
        
        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(jwtValue, expiraEm));
    }
}
