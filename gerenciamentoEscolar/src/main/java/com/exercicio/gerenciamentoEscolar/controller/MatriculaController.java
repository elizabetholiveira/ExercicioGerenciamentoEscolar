package com.exercicio.gerenciamentoEscolar.controller;

import com.exercicio.gerenciamentoEscolar.dto.MatriculaDTO;
import com.exercicio.gerenciamentoEscolar.service.MatriculaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maticula")
public class MatriculaController {

    @Autowired
    MatriculaService matriculaService;

    //Criar matrícula
    @PostMapping
    public ResponseEntity<MatriculaDTO> cadastrar(@RequestBody MatriculaDTO matriculaDTO){
        MatriculaDTO novaMatricula = matriculaService.cadastrar(matriculaDTO);
        return new ResponseEntity<>(novaMatricula, HttpStatus.CREATED);
    }

    //Atualizar matrícula
    @PutMapping(path = "/{id}")
    public MatriculaDTO atualizarMatricula(@PathVariable Long id, @RequestBody MatriculaDTO matriculaDTO){
        return matriculaService.alterar(id, matriculaDTO);
    }

    //Ver matrícula
    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> listarTodas(){ return ResponseEntity.ok(matriculaService.listarTodas());}
}
