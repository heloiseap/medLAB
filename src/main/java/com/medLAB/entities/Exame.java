package com.medLAB.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //obrigatorio
    //8~64
    private String nomeExame;

    //obrigatorio
    private LocalTime data;

    //obrigatorio
    private LocalTime hora;

    //obrigatorio
    //4~32
    private String tipo;

    //obrigatorio
    //4~32
    private String laboratorio;

    //n obrigatorio
    private String urlDocumento;

    //n obrigatorio
    //16~1024
    private String resultados;

    //obrigatorio
    //id
    //relacionamento
    private Paciente paciente;

}
