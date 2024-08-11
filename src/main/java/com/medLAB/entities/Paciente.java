package com.medLAB.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //obrigatorio
    //min 8 max 64
    private String nome;

    //obrigatorio
    private String genero;

    //obrigatorio
    //validacao
    private LocalTime dataNascimento;

    //obrigatorio
    //formato 000.000.000-00
    private String cpf;

    //obrigatorio
    //com orgao expeditor 0000000 UF/SSP
    //max 20
    private String rg;

    //obrigatorio
    private String estadoCivil;

    //obrigatorio
    //formato (99) 9 9999-9999
    private String telefone;

    //n obrigatorio
    //validacao
    private String email;

    //obrigatorio
    //min 8 max 64
    private String naturalidade;

    //obrigatorio
    //formato (99) 9 9999-9999
    //nome contato?
    private String contatoEmergencia;

    //n obrigatorio
    private List<String> listaAlergias;

    //n obrigatorio
    private List<String> cuidadosEspecificos;

    //n obrigatorio
    private String convenio;

    //n obrigatorio
    private String numeroConvenio;

    //n obrigatorio
    private LocalTime validadeConvenio;

    //obrigatorio
    @OneToOne
    private Endereco endereco;

    //id_usuario?
    //obrigatorio
    private Usuario usuario;
}
