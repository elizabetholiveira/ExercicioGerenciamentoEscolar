package com.exercicio.gerenciamentoEscolar.service;

import com.exercicio.gerenciamentoEscolar.dto.AlunosDTO;
import com.exercicio.gerenciamentoEscolar.dto.MatriculaDTO;
import com.exercicio.gerenciamentoEscolar.model.AlunosModel;
import com.exercicio.gerenciamentoEscolar.repository.AlunosRepository;
import com.exercicio.gerenciamentoEscolar.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunosService {

    @Autowired
    AlunosRepository alunosRepository;

    @Autowired
    MatriculaRepository matriculaRepository;

    //Cadastrar alunos
    public AlunosModel cadastrar(AlunosModel alunosModel){
        return alunosRepository.save(alunosModel);
    }

    //Listar alunos
    public List<AlunosModel> listarTodos(){
        return alunosRepository.findAll();
    }

    //Listar aluno por id
    public Optional<AlunosModel> listarAluno(Long id){
        return alunosRepository.findById(id);
    }

    //Deletar aluno
    public void deletar(Long id) {
        alunosRepository.deleteById(id);
    }
}
