package com.medLAB.mappers;

import com.medLAB.dtos.PacienteRequest;
import com.medLAB.dtos.PacienteResponse;
import com.medLAB.entities.Paciente;
import com.medLAB.repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacienteMapper {

    final PacienteRepository pacienteRepository;

    public static Paciente map(PacienteRequest request){
        Paciente paciente = new Paciente();
        paciente.setNome(request.getNome());
        paciente.setGenero(request.getCpf());
        paciente.setDataNascimento(request.getDataNascimento());
        paciente.setCpf(request.getCpf());
        paciente.setRg(request.getRg());
        paciente.setEstadoCivil(request.getEstadoCivil());
        paciente.setTelefone(request.getTelefone());
        paciente.setEmail(request.getEmail());
        paciente.setNaturalidade(request.getNaturalidade());
        paciente.setContatoEmergencia(request.getContatoEmergencia());
        paciente.setListaAlergias(request.getListaAlergias());
        paciente.setCuidadosEspecificos(request.getCuidadosEspecificos());
        paciente.setConvenio(request.getConvenio());
        paciente.setNumeroConvenio(request.getNumeroConvenio());
        paciente.setValidadeConvenio(request.getValidadeConvenio());
        paciente.setEndereco(request.getEndereco());
        return paciente;
    }

    public PacienteResponse map(Paciente request){
        PacienteResponse paciente = new PacienteResponse();
        paciente.setId(request.getId());
        paciente.setNome(request.getNome());
        paciente.setGenero(request.getCpf());
        paciente.setDataNascimento(request.getDataNascimento());
        paciente.setCpf(request.getCpf());
        paciente.setRg(request.getRg());
        paciente.setEstadoCivil(request.getEstadoCivil());
        paciente.setTelefone(request.getTelefone());
        paciente.setEmail(request.getEmail());
        paciente.setNaturalidade(request.getNaturalidade());
        paciente.setContatoEmergencia(request.getContatoEmergencia());
        paciente.setListaAlergias(request.getListaAlergias());
        paciente.setCuidadosEspecificos(request.getCuidadosEspecificos());
        paciente.setConvenio(request.getConvenio());
        paciente.setNumeroConvenio(request.getNumeroConvenio());
        paciente.setValidadeConvenio(request.getValidadeConvenio());
        paciente.setEndereco(request.getEndereco());
        return paciente;
    }
}
