package com.medLAB.services;

import com.medLAB.dtos.ConsultaRequest;
import com.medLAB.dtos.ConsultaResponse;
import com.medLAB.entities.Consulta;
import com.medLAB.entities.Paciente;
import com.medLAB.mappers.ConsultaMapper;
import com.medLAB.repositories.ConsultaRepository;
import com.medLAB.repositories.PacienteRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private ConsultaMapper mapper;

    public void criarConsulta(@RequestBody @Valid ConsultaRequest consultaRequest) {
        Paciente paciente = pacienteRepository.findById(consultaRequest.getIdPaciente()).get();
        if (paciente != null) {
            Consulta consulta = consultaRepository.save(mapper.map(consultaRequest, paciente));
        }
    }

    public ConsultaResponse mostrarConsulta(@PathVariable long id) {
        if (!consultaRepository.findById(id).isEmpty()) {
            ConsultaResponse response = mapper.map(consultaRepository.findById(id).get());
            return response;
        } else {
            throw new NoSuchElementException("Consulta não cadastrada");
        }
    }


    public void alterarConsulta(@PathVariable long id, @RequestBody @Valid ConsultaRequest request) {
        if (consultaRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("Consulta não encontrada");
        } else {

            Consulta consulta = consultaRepository.findById(id).get();

            if (!request.getMotivo().isEmpty()) {
                consulta.setMotivo(request.getMotivo());
            }
            if (!request.getData().toString().isEmpty()) {
                consulta.setData(request.getData());
            }
            if (!request.getHora().toString().isEmpty()) {
                consulta.setHora(request.getHora());
            }
            if (!request.getDescricaoProblema().isEmpty()) {
                consulta.setDescricaoProblema(request.getDescricaoProblema());
            }
            if (!request.getMedicacaoReceitada().isEmpty()) {
                consulta.setMedicacaoReceitada(request.getMedicacaoReceitada());
            }
            if (!request.getDosagemEPrecaucoes().isEmpty()) {
                consulta.setDosagemEPrecaucoes(request.getDosagemEPrecaucoes());
            }
            if (request.getIdPaciente() != null) {
                if (pacienteRepository.findById(id).isEmpty()) {
                    throw new RuntimeException("Paciente não encontrado");
                } else {
                    Paciente paciente = pacienteRepository.findById(id).get();
                    consulta.setPaciente(paciente);
                }
            }
            consultaRepository.save(consulta);
        }
    }

    public void deletarConsulta(@PathVariable long id) {
        if (consultaRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("Identificador não cadastrado");
        } else {
            consultaRepository.deleteById(id);
        }

    }

    public List<ConsultaResponse> mostrarConsultas() {
        return consultaRepository.findAll().stream().map(
                consulta -> new ConsultaResponse(
                        consulta.getId(),
                        consulta.getData(),
                        consulta.getHora(),
                        consulta.getPaciente().getId()
                )
        ).collect(Collectors.toList());
    }
}
