package com.medLAB.controllers;

import com.medLAB.dtos.UsuarioRequest;
import com.medLAB.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TokenController {

    private final JwtEncoder jwtEncoder;
    private final UsuarioService usuarioService;
    private static long TEMPO_EXPIRACAO = 36000L;

    @PostMapping("/login")
    public void logaUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest){
        UsuarioService.logar(usuarioRequest);
    }
}
