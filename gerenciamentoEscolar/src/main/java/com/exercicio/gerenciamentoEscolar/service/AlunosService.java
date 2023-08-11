package com.exercicio.gerenciamentoEscolar.service;

import com.exercicio.gerenciamentoEscolar.dto.AlunosDTO;
import com.exercicio.gerenciamentoEscolar.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunosService {

    @Autowired
    AlunosRepository alunosRepository;

    //Cadastrar alunos
    public AlunosDTO cadastrar(AlunosDTO alunosDTO){
        return alunosRepository.save(alunosDTO);
    }

    //Listar alunos
    public List<AlunosDTO> listarTodos(){
        return alunosRepository.findAll();
    }

    //Deletar aluno
    public void deletar(Long id){
        alunosRepository.deleteById(id);
    }
}
