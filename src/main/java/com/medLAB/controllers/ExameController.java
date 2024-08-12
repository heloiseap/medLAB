package com.medLAB.controllers;

import com.medLAB.dtos.ConsultaRequest;
import com.medLAB.dtos.ExameRequest;
import com.medLAB.services.ExameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ExameController {

    public final ExameService exameService;

    @PostMapping
    public void criaExame(@RequestBody @Valid ExameRequest exameRequest){
        exameService.criarExame(exameRequest);
    }

    @GetMapping("/{id}")
    public void mostraExame(@PathVariable long id){
        exameService.mostrarExame(id);
    }

    @PutMapping("/{id}")
    public void alteraExame(@PathVariable long id, @RequestBody @Valid ExameRequest request){
        exameService.alterarExame(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletaExame(@PathVariable long id){
        exameService.deletarExame(id);
    }

    @GetMapping
    public void mostraExame(){
        exameService.mostrarExames();
    }
}
