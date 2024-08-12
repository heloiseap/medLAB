package com.medLAB.controllers;

import com.medLAB.dtos.ConsultaRequest;
import com.medLAB.dtos.ConsultaResponse;
import com.medLAB.services.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.NoSuchElementException;

@RequestMapping(value = "/consultas")
@RestController
@RequiredArgsConstructor
public class ConsultaController {

    public final ConsultaService consultaService;


    //todo erro
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criaConsulta(@RequestBody @Valid ConsultaRequest consultaRequest){
        try {
            consultaService.criarConsulta(consultaRequest);

        } catch (HttpServerErrorException.InternalServerError exception) {
            //throw new MethodArgumentNotValidException();
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ConsultaResponse> mostraConsulta(@PathVariable long id){
        ConsultaResponse response = consultaService.mostrarConsulta(id);
        if (response!=null) {
            return ResponseEntity.ok(response);
        } else {
            throw new NoSuchElementException("Consulta não encontrada");
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void alteraConsulta(@PathVariable long id, @RequestBody @Valid ConsultaRequest consultaRequest){
        consultaService.alterarConsulta(id, consultaRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletaConsulta(@PathVariable long id){
        consultaService.deletarConsulta(id);
    }

    @GetMapping
    public void mostraConsulta(){
        consultaService.mostrarConsultas();
    }
}
