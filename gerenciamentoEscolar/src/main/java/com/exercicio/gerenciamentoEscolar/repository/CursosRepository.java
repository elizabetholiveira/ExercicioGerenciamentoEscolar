package com.exercicio.gerenciamentoEscolar.repository;

import com.exercicio.gerenciamentoEscolar.model.CursosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosRepository extends JpaRepository<CursosModel, Long> {
}
