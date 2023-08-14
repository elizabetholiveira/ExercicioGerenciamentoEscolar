package com.exercicio.gerenciamentoEscolar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {

    private Long id;
    private String dataMatricula;
    private Long aluno;
    private Long curso;
}
