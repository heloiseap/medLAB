package com.medLAB.controllers;

import com.medLAB.dtos.PerfilRequest;
import com.medLAB.services.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PerfilController {
    private final PerfilService perfilService;

    @PostMapping("/")
    public ResponseEntity<String> cadastraPerfil(@RequestBody PerfilRequest perfilRequest){
        perfilService.cadastrarPerfil(perfilRequest);
        return new ResponseEntity<>("Perfil Criado", HttpStatus.CREATED);
    }
}
