package com.medLAB.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Pattern(regexp = "\\d\\d\\d\\d\\d-\\d\\d\\d")
    private String cep;

    @Size(max = 50)
    private String cidade;

    @Size(min = 3, max = 19)
    private String estado;


    @Size(min = 4, max = 20)
    private String logradouro;

    @Column(nullable = false)
    private Integer numero;

    @Size(max = 20)
    private String complemento;

    @Size(min = 3, max = 20)
    private String bairro;

    @Size(min = 3, max = 20)
    private String pontoReferencia;
}
