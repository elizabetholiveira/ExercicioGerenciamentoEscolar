package com.exercicio.gerenciamentoEscolar.controller;

import com.exercicio.gerenciamentoEscolar.dto.AlunosDTO;
import com.exercicio.gerenciamentoEscolar.service.AlunosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunosController {

    @Autowired
    AlunosService alunosService;

    //Cadastrar aluno
    @PostMapping
    public ResponseEntity<AlunosDTO> cadastrar(@RequestBody AlunosDTO alunosDTO){
        AlunosDTO novoAluno = alunosService.cadastrar(alunosDTO);
        return new ResponseEntity<>(novoAluno, HttpStatus.CREATED);
    }

    //Listar alunos
    @GetMapping
    public ResponseEntity<List<AlunosDTO>> listarTodos(){
        return ResponseEntity.ok(alunosService.listarTodos());
    }

    //Deletar aluno
    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id){
        alunosService.deletar(id);
        ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso");
    }

}
