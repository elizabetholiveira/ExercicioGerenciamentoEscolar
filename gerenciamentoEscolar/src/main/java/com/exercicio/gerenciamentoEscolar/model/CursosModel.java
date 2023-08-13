package com.exercicio.gerenciamentoEscolar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_CURSOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 5, nullable = false)
    private String cargaHoraria;
}
