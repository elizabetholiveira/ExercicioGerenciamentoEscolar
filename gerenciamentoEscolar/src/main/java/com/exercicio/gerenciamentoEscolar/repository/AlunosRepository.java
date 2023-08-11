package com.exercicio.gerenciamentoEscolar.repository;

import com.exercicio.gerenciamentoEscolar.dto.AlunosDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunosRepository extends JpaRepository<AlunosDTO, Long> {
}
