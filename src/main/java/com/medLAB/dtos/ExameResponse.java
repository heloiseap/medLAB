package com.medLAB.dtos;

import lombok.RequiredArgsConstructor;

import java.time.LocalTime;

@RequiredArgsConstructor
public class ExameResponse {
    private final long id;
    private final String nomeExame;
    private final LocalTime data;
    private LocalTime hora;
    private String tipo;
    private String laboratorio;
    private String urlDocumento;
    private String resultados;
    private final Long idPaciente;
}
