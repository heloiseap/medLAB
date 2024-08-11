package com.medLAB.controllers;

import com.medLAB.dtos.ConsultaRequest;
import com.medLAB.services.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/consultas")
@RestController
@RequiredArgsConstructor
public class ConsultaController {

    public final ConsultaService consultaService;

    @PostMapping
    public void criaConsulta(@RequestBody @Valid ConsultaRequest consultaRequest){
        consultaService.criarConsulta(consultaRequest);
    }

    @GetMapping("/{id}")
    public void mostraConsulta(@PathVariable long id){
        consultaService.mostrarConsulta(id);
    }

    @PutMapping("/{id}")
    public void alteraConsulta(@PathVariable long id, @RequestBody @Valid ConsultaRequest consultaRequest){
        consultaService.alterarConsulta(id, consultaRequest);
    }

    @DeleteMapping("/{id}")
    public void deletaConsulta(@PathVariable long id){
        consultaService.deletarConsulta(id);
    }

    @GetMapping
    public void mostraConsulta(){
        consultaService.mostrarConsultas();
    }
}
