package com.medLAB.dtos;

import com.medLAB.entities.Paciente;
import lombok.Data;

import java.time.LocalTime;

@Data
public class ExameRequest {
    private String nomeExame;
    private LocalTime data;
    private LocalTime hora;
    private String tipo;
    private String laboratorio;
    private String urlDocumento;
    private String resultados;
    private Long idPaciente;
}
