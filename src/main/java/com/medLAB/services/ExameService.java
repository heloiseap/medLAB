package com.medLAB.services;

import com.medLAB.dtos.ExameRequest;
import com.medLAB.dtos.ExameResponse;
import com.medLAB.entities.Exame;
import com.medLAB.entities.Paciente;
import com.medLAB.mappers.ExameMapper;
import com.medLAB.repositories.ConsultaRepository;
import com.medLAB.repositories.ExameRepository;
import com.medLAB.repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ExameService {

    private final ExameMapper mapper;
    private final ExameRepository exameRepository;
    private final PacienteRepository pacienteRepository;

    //erros: req invalido, paciente nao encontrado
    public void criarExame(ExameRequest exameRequest) {
        exameRepository.save(mapper.map(exameRequest));
    }

    //erros: id n encontrado/invalido
    public void mostrarExame(long id) {
        Exame exame= exameRepository.findById(id).get();
    }

    //erro exame n encontrado
    //parametros do request nao obrigatorios
    //request vazio erro
    public void alterarExame(@PathVariable long id, ExameRequest request) {
        if (exameRepository.findById(id).isEmpty()){
            //erro
        } else {
            Exame exame = exameRepository.findById(id).get();

            if(!request.getNomeExame().isEmpty()){
                exame.setNomeExame(request.getNomeExame());
            }
            if(!request.getData().toString().isEmpty()){
                exame.setData(request.getData());
            }
            if(!request.getHora().toString().isEmpty()){
                exame.setHora(request.getHora());
            }
            if(!request.getTipo().isEmpty()){
                exame.setTipo(request.getTipo());
            }
            if(!request.getLaboratorio().isEmpty()){
                exame.setLaboratorio(request.getLaboratorio());
            }
            if(!request.getUrlDocumento().isEmpty()){
                exame.setUrlDocumento(request.getUrlDocumento());
            }
            if(request.getIdPaciente() != null){
                if (pacienteRepository.findById(id).isEmpty()){
                    //erro
                } else {
                    Paciente paciente = pacienteRepository.findById(id).get();
                    exame.setPaciente(paciente);
                }
            }
        }
    }

    public void deletarExame(long id) {
     if (exameRepository.findById(id).isEmpty()){
         //erro
     } else {
         exameRepository.deleteById(id);
     }
    }

    public List<ExameResponse> mostrarExames() {
        return exameRepository.findAll().stream().map(
                exame -> new ExameResponse(
                        exame.getId(),
                        exame.getNomeExame(),
                        exame.getData(),
                        exame.getPaciente().getId()
                )
        ).collect(Collectors.toList());

    }
}
