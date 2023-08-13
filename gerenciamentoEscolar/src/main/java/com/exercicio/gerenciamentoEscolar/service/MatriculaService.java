package com.exercicio.gerenciamentoEscolar.service;

import com.exercicio.gerenciamentoEscolar.dto.MatriculaDTO;
import com.exercicio.gerenciamentoEscolar.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;

    //Criar matrícula
    public MatriculaDTO cadastrar(MatriculaDTO matriculaDTO){
        return matriculaRepository.save(matriculaDTO);
    }

    //Atualizar matrícula
    public MatriculaDTO alterar(Long id, MatriculaDTO matriculaDTO){

        MatriculaDTO matricula = matriculaRepository.findById(id).get();

        if (matriculaDTO.getCurso() != null){
            matriculaDTO.setCurso(matriculaDTO.getCurso());
        }

        return matriculaRepository.save(matricula);
    }

    //Ver matrículas
    public List<MatriculaDTO> listarTodas(){
        return matriculaRepository.findAll();
    }
}
