package com.exercicio.gerenciamentoEscolar.service;

import com.exercicio.gerenciamentoEscolar.dto.ProfessoresDTO;
import com.exercicio.gerenciamentoEscolar.repository.ProfessoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessoresService {

    @Autowired
    ProfessoresRepository professoresRepository;

    //Cadastrar alunos
    public ProfessoresDTO cadastrar(ProfessoresDTO professoresDTO){
        return professoresRepository.save(professoresDTO);
    }

    //Listar alunos
    public List<ProfessoresDTO> listarTodos(){
        return professoresRepository.findAll();
    }

    //Deletar aluno
    public void deletar(Long id){
        professoresRepository.deleteById(id);
    }

}
