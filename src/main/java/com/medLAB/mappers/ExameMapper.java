package com.medLAB.mappers;

import com.medLAB.dtos.ExameRequest;
import com.medLAB.entities.Exame;
import com.medLAB.entities.Paciente;
import com.medLAB.repositories.ExameRepository;
import com.medLAB.repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExameMapper {

    final PacienteRepository pacienteRepository;
    final ExameRepository exameRepository;

    public Exame map(ExameRequest exameRequest) {

        if (pacienteRepository.findById(exameRequest.getIdPaciente()).isEmpty()){
            return null;
        } else {
            Paciente paciente = pacienteRepository.findById(exameRequest.getIdPaciente()).get();
            Exame exame = new Exame();
            exame.setNomeExame(exameRequest.getNomeExame());
            exame.setData(exameRequest.getData());
            exame.setHora(exameRequest.getHora());
            exame.setLaboratorio(exameRequest.getLaboratorio());
            exame.setTipo(exameRequest.getTipo());
            exame.setResultados(exameRequest.getTipo());
            exame.setUrlDocumento(exameRequest.getUrlDocumento());
            exame.setPaciente(paciente);
            return exame;
        }
    }
}
