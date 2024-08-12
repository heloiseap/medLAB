package com.medLAB.controllers;

import com.medLAB.dtos.LoginRequest;
import com.medLAB.dtos.LoginResponse;
import com.medLAB.dtos.UsuarioRequest;
import com.medLAB.entities.Usuario;
import com.medLAB.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class TokenController {

    private final JwtEncoder jwtEncoder;
    private final UsuarioService usuarioService;
    private static long TEMPO_EXPIRACAO = 36000L;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> geraToken(@RequestBody @Valid LoginRequest loginRequest){
        Usuario usuarioEntity = usuarioService.validarUsuario(loginRequest);
        Instant agora = Instant.now();
        String scope = usuarioEntity.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(agora)
                .expiresAt(agora.plusSeconds(TEMPO_EXPIRACAO))
                .subject(usuarioEntity.getUsername())
                .claim("scope", scope)
                .build();
        var valorJwt = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        return ResponseEntity.ok(new LoginResponse(valorJwt, TEMPO_EXPIRACAO));
    }
}
