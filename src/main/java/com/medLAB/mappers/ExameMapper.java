package com.medLAB.mappers;

import com.medLAB.dtos.ExameRequest;
import com.medLAB.entities.Exame;
import com.medLAB.entities.Paciente;
import com.medLAB.repositories.ExameRepository;
import com.medLAB.repositories.PacienteRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
public class ExameMapper {

    public static Exame map(ExameRequest exameRequest, Paciente paciente) {

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
