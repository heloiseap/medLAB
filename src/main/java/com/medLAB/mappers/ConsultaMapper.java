package com.medLAB.mappers;

import com.medLAB.dtos.ConsultaRequest;
import com.medLAB.dtos.PacienteResponse;
import com.medLAB.entities.Consulta;
import com.medLAB.entities.Paciente;
import com.medLAB.repositories.ConsultaRepository;
import com.medLAB.repositories.PacienteRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@RequiredArgsConstructor
public class ConsultaMapper {

    final PacienteRepository pacienteRepository;
    final ConsultaRepository consultaRepository;

    public Consulta map(ConsultaRequest consultaRequest){

        //msg erro
        if (pacienteRepository.findById(consultaRequest.getIdPaciente()).isEmpty()){
            return null;
        } else {
            Paciente paciente = pacienteRepository.findById(consultaRequest.getIdPaciente()).get();
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
    }
}
