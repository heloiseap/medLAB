package com.medLAB.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "exame")
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 8, max = 64)
    private String nomeExame;

    @Column(nullable = false)
    private LocalTime data;

    @Column(nullable = false)
    private LocalTime hora;

    @Column(nullable = false)
    @Size(min = 4, max = 32)
    private String tipo;

    @Column(nullable = false)
    @Size(min = 4, max = 32)
    private String laboratorio;

    @Size(max = 1024)
    private String urlDocumento;

    @Size(min = 16, max = 1024)
    private String resultados;

    @ManyToOne
    @JoinColumn(name="id_paciente")
    private Paciente paciente;

}
