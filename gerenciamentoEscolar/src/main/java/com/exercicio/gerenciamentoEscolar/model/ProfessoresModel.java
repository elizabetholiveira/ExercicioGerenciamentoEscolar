package com.exercicio.gerenciamentoEscolar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_PROFESSORES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessoresModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 3, nullable = false)
    private String idade;

    @ManyToOne
    @JoinColumn(name = "cursos_id")
    private CursosModel curso;

    @Column(nullable = false)
    private BigDecimal salario;
}
