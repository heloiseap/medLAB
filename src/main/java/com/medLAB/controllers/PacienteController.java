package com.medLAB.controllers;

import com.medLAB.dtos.PacienteRequest;
import com.medLAB.services.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/pacientes")
@RestController
@RequiredArgsConstructor
public class PacienteController {

    public final PacienteService pacienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastroPaciente(@RequestBody @Valid PacienteRequest pacienteRequest){
        pacienteService.cadastrarPaciente(pacienteRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public void mostraPaciente(@PathVariable long id){
        pacienteService.mostrarPaciente(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void alteraPaciente(@PathVariable long id, @RequestBody PacienteRequest request){
        pacienteService.alterarPaciente(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletaPaciente(@PathVariable long id){
        pacienteService.deletarPaciente(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void mostraPacientes(){
        pacienteService.mostrarPacientes();
    }


    @GetMapping("/prontuarios")
    @ResponseStatus(HttpStatus.FOUND)
    public void mostraProntuarios(@Valid
                                      @RequestParam(value = "nome", required = false) String nome,
                                      @RequestParam(value = "id", required = false) Long id){
        pacienteService.mostrarProntuarios(nome, id);
    }

    @GetMapping("/{id}/prontuarios")
    @ResponseStatus(HttpStatus.FOUND)
    public void mostraProntuario(@PathVariable long id){
        pacienteService.mostrarProntuario(id);
    }

}
