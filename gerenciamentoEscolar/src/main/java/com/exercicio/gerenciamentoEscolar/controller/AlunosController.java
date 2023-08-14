package com.exercicio.gerenciamentoEscolar.controller;

import com.exercicio.gerenciamentoEscolar.dto.AlunosDTO;
import com.exercicio.gerenciamentoEscolar.model.AlunosModel;
import com.exercicio.gerenciamentoEscolar.service.AlunosService;
import com.exercicio.gerenciamentoEscolar.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/alunos")
public class AlunosController {

    @Autowired
    AlunosService alunosService;

    @Autowired
    MatriculaService matriculaService;

    //Cadastrar aluno
    @PostMapping
    public ResponseEntity<AlunosModel> cadastrar(@RequestBody AlunosModel alunosModel){
        AlunosModel novoAluno = alunosService.cadastrar(alunosModel);
        return new ResponseEntity<>(novoAluno, HttpStatus.CREATED);
    }

    //Listar alunos
    @GetMapping
    public ResponseEntity<List<AlunosModel>> listarTodos(){
        return ResponseEntity.ok(alunosService.listarTodos());
    }

    //Deletar aluno
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id){
        Optional<AlunosModel> alunosModelOptional = alunosService.listarAluno(id);

        if (alunosModelOptional.isPresent()){
            AlunosModel aluno = alunosModelOptional.get();
            matriculaService.deletarMatriculaAluno(aluno);
            alunosService.deletar(id);
            return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
    }
//    public void deletar(@PathVariable Long id){
//        alunosService.deletar(id);
//        //ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso");
//    }

}
