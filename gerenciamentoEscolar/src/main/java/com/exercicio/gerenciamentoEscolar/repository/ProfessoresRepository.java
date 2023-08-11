package com.exercicio.gerenciamentoEscolar.repository;

import com.exercicio.gerenciamentoEscolar.dto.ProfessoresDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessoresRepository extends JpaRepository<ProfessoresDTO, Long> {
}
