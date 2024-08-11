package com.medLAB.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //obrigatorio
    //8~64
    private String motivo;

    //obrigatorio
    private LocalDate data;

    //obrigatorio
    private LocalTime hora;

    //obrigatorio
    //16~1024
    private String descricaoProblema;

    //n obrigatorio
    private String medicacaoReceitada;

    //n obrigatorio
    //16~256
    private String dosagemEPrecaucoes;

    //obrigatorio
    //relacionamento
    //id
    private Paciente paciente;
}
