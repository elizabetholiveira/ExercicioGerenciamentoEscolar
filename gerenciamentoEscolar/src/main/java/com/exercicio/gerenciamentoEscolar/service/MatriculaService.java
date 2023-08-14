package com.exercicio.gerenciamentoEscolar.service;

import com.exercicio.gerenciamentoEscolar.dto.MatriculaDTO;
import com.exercicio.gerenciamentoEscolar.model.AlunosModel;
import com.exercicio.gerenciamentoEscolar.model.CursosModel;
import com.exercicio.gerenciamentoEscolar.model.MatriculaModel;
import com.exercicio.gerenciamentoEscolar.repository.AlunosRepository;
import com.exercicio.gerenciamentoEscolar.repository.CursosRepository;
import com.exercicio.gerenciamentoEscolar.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;

    @Autowired
    AlunosRepository alunosRepository;

    @Autowired
    CursosRepository cursosRepository;

    //Criar matrícula
    public ResponseEntity<Object> cadastrar(MatriculaDTO matriculaDTO){
        Optional<AlunosModel> alunosModelOptional = alunosRepository.findById(matriculaDTO.getAluno());
        Optional<CursosModel> cursosModelOptional = cursosRepository.findById(matriculaDTO.getCurso());

        if (alunosModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Aluno não encontrado");
        }

        if (cursosModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Curso não encontrado");
        }

        MatriculaModel matriculaModel = new MatriculaModel();
        matriculaModel.setDataMatricula(matriculaDTO.getDataMatricula());
        matriculaModel.setAluno(alunosModelOptional.get());
        matriculaModel.setCurso(cursosModelOptional.get());

        MatriculaModel matricula = matriculaRepository.save(matriculaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Matrícula criada com sucesso!");
    }

    //Atualizar matrícula
    public MatriculaModel alterar(Long id, MatriculaModel matriculaModel){

        MatriculaModel matricula = matriculaRepository.findById(id).get();

        if (matriculaModel.getCurso() != null){
            matriculaModel.setCurso(matriculaModel.getCurso());
        }

        return matriculaRepository.save(matricula);
    }

    //Ver matrículas
    public List<MatriculaModel> listarTodas(){
        return matriculaRepository.findAll();
    }

    //Deletar matrícula
    public void deletar(Long id){matriculaRepository.deleteById(id);}

    //Deletar matrícula por aluno
    @Transactional
    public void deletarMatriculaAluno(AlunosModel alunosModel){
        matriculaRepository.deleteByAluno(alunosModel);
    }
}
