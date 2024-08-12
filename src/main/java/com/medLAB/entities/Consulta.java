package com.medLAB.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 8,max = 64)
    private String motivo;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private LocalTime hora;

    @Column(nullable = false)
    @Size(min = 16, max = 1024)
    private String descricaoProblema;

    private String medicacaoReceitada;

    @Size(min = 16, max = 256)
    private String dosagemEPrecaucoes;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
}
