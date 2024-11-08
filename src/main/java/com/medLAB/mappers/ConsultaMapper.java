package com.medLAB.mappers;

import com.medLAB.dtos.ConsultaRequest;
import com.medLAB.dtos.ConsultaResponse;
import com.medLAB.dtos.PacienteResponse;
import com.medLAB.entities.Consulta;
import com.medLAB.entities.Paciente;
import com.medLAB.repositories.ConsultaRepository;
import com.medLAB.repositories.PacienteRepository;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class ConsultaMapper {

    public static Consulta map(ConsultaRequest consultaRequest, Paciente paciente) {

        Consulta consulta = new Consulta();
        consulta.setMotivo(consultaRequest.getMotivo());
        consulta.setData(consultaRequest.getData());
        consulta.setHora(consultaRequest.getHora());
        consulta.setDescricaoProblema(consultaRequest.getDescricaoProblema());
        consulta.setMedicacaoReceitada(consultaRequest.getMedicacaoReceitada());
        consulta.setDosagemEPrecaucoes(consultaRequest.getDosagemEPrecaucoes());
        consulta.setPaciente(paciente);

        return consulta;
    }

    public ConsultaResponse map(Consulta consulta) {
        ConsultaResponse consultaResponse = new ConsultaResponse();
        consultaResponse.setMotivo(consulta.getMotivo());
        consultaResponse.setData(consulta.getData());
        consultaResponse.setHora(consulta.getHora());
        consultaResponse.setDescricaoProblema(consulta.getDescricaoProblema());
        consultaResponse.setMedicacaoReceitada(consulta.getMedicacaoReceitada());
        consultaResponse.setDosagemEPrecaucoes(consulta.getDosagemEPrecaucoes());
        consultaResponse.setIdPaciente(consulta.getPaciente().getId());

        return consultaResponse;
    }
}
