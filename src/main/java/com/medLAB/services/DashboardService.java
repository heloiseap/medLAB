package com.medLAB.services;

import com.medLAB.dtos.ConsultaRequest;
import com.medLAB.repositories.ConsultaRepository;
import com.medLAB.repositories.ExameRepository;
import com.medLAB.repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DashboardService {

    public final PacienteRepository pacienteRepository;
    public final ConsultaRepository consultaRepository;
    public final ExameRepository exameRepository;


    public void mostrarEstatistiscas() {

        Long nPacientes = pacienteRepository.count();
        Long nConsultas = consultaRepository.count();
        Long nExames = exameRepository.count();

    }
}
