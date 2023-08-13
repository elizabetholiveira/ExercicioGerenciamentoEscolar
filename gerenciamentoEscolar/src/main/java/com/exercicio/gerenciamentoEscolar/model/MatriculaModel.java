package com.exercicio.gerenciamentoEscolar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_MATRICULA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String dataMatricula;

    @ManyToOne
    @JoinColumn(name = "alunos_id")
    private AlunosModel aluno;

    @ManyToOne
    @JoinColumn(name = "cursos_id")
    private CursosModel curso;
}
