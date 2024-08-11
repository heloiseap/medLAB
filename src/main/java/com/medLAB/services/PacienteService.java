package com.medLAB.services;

import com.medLAB.dtos.PacienteRequest;
import com.medLAB.dtos.PacienteResponse;
import com.medLAB.entities.Paciente;
import com.medLAB.mappers.PacienteMapper;
import com.medLAB.repositories.PacienteRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper mapper;

    public void cadastrarPaciente(@RequestBody @Valid PacienteRequest pacienteRequest) {
        pacienteRepository.save(mapper.map(pacienteRequest));
    }

    public void mostrarPaciente(@PathVariable long id) {
        PacienteResponse pacienteResponse = mapper.map(pacienteRepository.findById(id).get());
    }

    public void alterarPaciente(@PathVariable long id, @RequestBody @Valid PacienteRequest request) {
        if(pacienteRepository.findById(id).isEmpty()){
            //erro
        } else {
            Paciente paciente = pacienteRepository.findById(id).get();
            if(!request.getNome().isEmpty()){
                paciente.setNome(request.getNome());
            }
            if(!request.getGenero().isEmpty()){
                paciente.setGenero(request.getGenero());
            }
            if(!request.getDataNascimento().toString().isEmpty()){
                paciente.setDataNascimento(request.getDataNascimento());
            }
            if(!request.getCpf().isEmpty()){
                paciente.setCpf(request.getCpf());
            }
            if(!request.getRg().isEmpty()){
                paciente.setRg(request.getRg());
            }
            if(!request.getEstadoCivil().isEmpty()){
                paciente.setEstadoCivil(request.getEstadoCivil());
            }
            if(!request.getTelefone().isEmpty()){
                paciente.setTelefone(request.getTelefone());
            }
            if(!request.getEmail().isEmpty()){
                paciente.setEmail(request.getEmail());
            }
            if(!request.getNaturalidade().isEmpty()){
                paciente.setNaturalidade(request.getNaturalidade());
            }
            if(!request.getContatoEmergencia().isEmpty()){
                paciente.setContatoEmergencia(request.getContatoEmergencia());
            }
            if(!request.getAlergia().isEmpty()){
                paciente.adicionarAlergia(id, request.getAlergia());
            }
            if(!request.getCuidadosEspecificos().isEmpty()){
                paciente.adicionarCuidadoEspecial(id, request.getCuidado());
            }
            if(!request.getConvenio().isEmpty()){
                paciente.setConvenio(request.getConvenio());
            }
            if(!request.getNumeroConvenio().isEmpty()){
                paciente.setNumeroConvenio(request.getNumeroConvenio());
            }
            if(!request.getValidadeConvenio().toString().isEmpty()){
                paciente.setValidadeConvenio(request.getValidadeConvenio());
            }
            if(request.getEndereco() != null){
                paciente.setEndereco(request.getEndereco());
            }

        }
    }

    public void deletarPaciente(@PathVariable long id) {
        pacienteRepository.deleteById(id);
    }

    public List<PacienteResponse> mostrarPacientes() {
        return pacienteRepository.findAll().stream().map(
                paciente -> new PacienteResponse(
                        paciente.getId(),
                        paciente.getNome(),
                        paciente.getCpf()
                )
        ).collect(Collectors.toList());

    }

    public PacienteResponse mostrarProntuario(@PathVariable long id) {
        return mapper.map(pacienteRepository.findById(id).get());
    }

    //buscar por nome ou id? todo
    public void mostrarProntuarios() {

    }
}
