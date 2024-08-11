package com.medLAB.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ConsultaResponse {
    private final long id;
    private String motivo;
    private final LocalDate data;
    private final LocalTime hora;
    private String descricaoProblema;
    private String medicacaoReceitada;
    private String dosagemEPrecaucoes;
    private final Long idPaciente;
}
