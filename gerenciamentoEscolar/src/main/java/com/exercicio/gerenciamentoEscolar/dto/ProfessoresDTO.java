package com.exercicio.gerenciamentoEscolar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessoresDTO {

    private Long id;
    private String nome;
    private String idade;
    private Long curso;
    private BigDecimal salario;
}
