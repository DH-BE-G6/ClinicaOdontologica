package com.digitalhouse.clinicaodontologicag6.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Dentistas")
public class DentistaEntity {

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

    @Column(name = "matricula", unique = true, nullable = false)
    @NotNull
    private String matricula;

}
