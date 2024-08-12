package com.medLAB.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Data
public class ConsultaResponse {
    private Long id;
    private String motivo;
    private LocalDate data;
    private LocalTime hora;
    private String descricaoProblema;
    private String medicacaoReceitada;
    private String dosagemEPrecaucoes;
    private Long idPaciente;

    public ConsultaResponse(Long id, LocalDate data, LocalTime hora, Long id1) {
    }
}
