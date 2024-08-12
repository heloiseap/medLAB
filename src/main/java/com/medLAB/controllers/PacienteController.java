package com.medLAB.controllers;

import com.medLAB.dtos.PacienteRequest;
import com.medLAB.services.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/pacientes")
@RestController
@RequiredArgsConstructor
public class PacienteController {

    public final PacienteService pacienteService;

    @PostMapping
    public void cadastroPaciente(@RequestBody @Valid PacienteRequest pacienteRequest){
        pacienteService.cadastrarPaciente(pacienteRequest);
    }

    @GetMapping("/{id}")
    public void mostraPaciente(@PathVariable long id){
        pacienteService.mostrarPaciente(id);
    }

    @PutMapping("/{id}")
    public void alteraPaciente(@PathVariable long id, @RequestBody PacienteRequest request){
        pacienteService.alterarPaciente(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletaPaciente(@PathVariable long id){
        pacienteService.deletarPaciente(id);
    }

    @GetMapping
    public void mostraPacientes(){
        pacienteService.mostrarPacientes();
    }


    //parametros opcionais: nome, num registro
    @GetMapping("/prontuarios")
    public void mostraProntuarios(){
        pacienteService.mostrarProntuarios();
    }

    @GetMapping("/{id}/prontuarios")
    public void mostraProntuario(@PathVariable long id){
        pacienteService.mostrarProntuario(id);
    }

}
