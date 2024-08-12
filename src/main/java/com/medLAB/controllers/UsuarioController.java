package com.medLAB.controllers;

import com.medLAB.dtos.UsuarioRequest;
import com.medLAB.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/usuarios")
@RestController
@RequiredArgsConstructor
public class UsuarioController {

    public final UsuarioService usuarioService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastraUsuario (@RequestBody @Valid UsuarioRequest usuarioRequest){
        usuarioService.cadastrarUsuario(usuarioRequest);
    }


}
