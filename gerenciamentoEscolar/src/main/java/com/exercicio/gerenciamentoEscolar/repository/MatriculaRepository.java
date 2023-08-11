package com.exercicio.gerenciamentoEscolar.repository;

import com.exercicio.gerenciamentoEscolar.dto.MatriculaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<MatriculaDTO, Long> {
}
