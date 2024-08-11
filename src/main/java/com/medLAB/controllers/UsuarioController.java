package com.medLAB.controllers;

import com.medLAB.dtos.UsuarioRequest;
import com.medLAB.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/usuarios")
@RestController
@RequiredArgsConstructor
public class UsuarioController {

    public final UsuarioService usuarioService;

    @PostMapping()
    public void cadastraUsuario (@RequestBody @Valid UsuarioRequest usuarioRequest){
        usuarioService.cadastrarUsuario(usuarioRequest);
    }


}
