package com.medLAB.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ConsultaRequest {
    private String motivo;
    private LocalDate data;
    private LocalTime hora;
    private String descricaoProblema;
    private String medicacaoReceitada;
    private String dosagemEPrecaucoes;
    private Long idPaciente;
}
