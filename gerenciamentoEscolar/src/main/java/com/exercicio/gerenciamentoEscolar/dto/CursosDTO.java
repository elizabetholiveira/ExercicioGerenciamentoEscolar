package com.exercicio.gerenciamentoEscolar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursosDTO {

    private Long id;
    private String nome;
    private String cargaHoraria;
}
