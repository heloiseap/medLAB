package com.medLAB.dtos;

import com.medLAB.entities.Endereco;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
public class PacienteResponse {
    private long id;
    private String nome;
    private String genero;
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;
    private String estadoCivil;
    private String telefone;
    private String email;
    private String naturalidade;
    private String contatoEmergencia;
    private List<String> listaAlergias;
    private List<String> cuidadosEspecificos;
    private String convenio;
    private String numeroConvenio;
    private LocalDate validadeConvenio;
    private Endereco endereco;

    public PacienteResponse(Long id, String nome, String cpf) {
    }
}
