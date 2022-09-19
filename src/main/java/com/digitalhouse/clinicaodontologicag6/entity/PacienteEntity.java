package com.digitalhouse.clinicaodontologicag6.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Pacientes")
@SecondaryTable(name = "Enderecos")
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    @NotNull
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    @NotNull
    private String sobrenome;

    @Column(name = "rg", unique = true, nullable = false)
    @NotNull
    private String rg;

    @Column(name = "dataAlta")
    private String dataAlta;

    @Column(table = "Enderecos", name = "logradouro", nullable = false)
    @NotNull
    private String logradouro;

    @Column(table = "Enderecos", name = "numero", nullable = false)
    @NotNull
    private String numero;

    @Column(table = "Enderecos", name = "complemento")
    private String complemento;

    @Column(table = "Enderecos", name = "bairro", nullable = false)
    @NotNull
    private String bairro;

    @Column(table = "Enderecos", name = "cidade", nullable = false)
    @NotNull
    private String cidade;

    @Column(table = "Enderecos", name = "estado", nullable = false)
    @NotNull
    private String estado;

    @Column(table = "Enderecos", name = "cep", nullable = false)
    @NotNull
    private String cep;

}
