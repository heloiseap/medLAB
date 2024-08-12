package com.medLAB.entities;

import com.medLAB.repositories.PacienteRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id;

    @Column(nullable = false)
    @Size(min = 8, max = 64)
    private String nome;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    @Past
    private LocalDate dataNascimento;

    @Column(nullable = false)
    @Pattern(regexp = "\\d\\d\\d\\.\\d\\d\\d\\.\\d\\d\\d-\\d\\d")
    private String cpf;

    @Column(nullable = false)
    @Pattern(regexp = "\\d.*\\d\\d\\d.*\\d\\d\\d\\s[A-Za-z][A-Za-z]/[A-Za-z]{2,20}")
    @Size(max = 36)
    private String rg;

    @Column(nullable = false)
    private String estadoCivil;

    @Column(nullable = false)
    @Pattern(regexp = "\\(\\d\\d\\)\\s9\\s[0-9]+-[0-9]+")
    private String telefone;

    @Email
    private String email;

    @Column(nullable = false)
    @Size(min = 8, max = 64)
    private String naturalidade;

    @Column(nullable = false)
    @Pattern(regexp = "\\(\\d\\d\\)\\s9\\s[0-9]+-[0-9]+")
    private String contatoEmergencia;

    private List<String> listaAlergias;

    private List<String> cuidadosEspecificos;

    private String convenio;

    private String numeroConvenio;

    private LocalDate validadeConvenio;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    //id_usuario?
    @Column(nullable = false)
    private Usuario usuario;

    public void adicionarAlergia(Paciente paciente, String alergia){
        List<String> listaAlergias = paciente.getListaAlergias();
        listaAlergias.add(alergia);
    }
    public void adicionarCuidadoEspecial(Paciente paciente, String cuidado){
        List<String> listaCuidados = paciente.getCuidadosEspecificos();
        listaCuidados.add(cuidado);
    }
}
