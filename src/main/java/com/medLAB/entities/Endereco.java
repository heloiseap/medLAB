package com.medLAB.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //obrigatorio
    //formato 88888-888
    private String cep;

    //obrigatorio
    //3~64?
    private String cidade;

    //obrigatorio
    //2-32?
    private String estado;

    //obrigatorio
    //12-64?
    private String logradouro;

    //obrigatorio
    private Integer numero;

    //n obrigatorio
    private String complemento;

    //obrigatorio
    //8~64
    private String bairro;

    //n obrigatorio
    //8~64?
    private String pontoReferencia;

}
