package com.exercicio.gerenciamentoEscolar.controller;

import com.exercicio.gerenciamentoEscolar.dto.MatriculaDTO;
import com.exercicio.gerenciamentoEscolar.model.MatriculaModel;
import com.exercicio.gerenciamentoEscolar.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matricula")
public class MatriculaController {

    @Autowired
    MatriculaService matriculaService;

    //Criar matrícula
    @PostMapping
    public ResponseEntity<ResponseEntity<Object>> cadastrar(@RequestBody MatriculaDTO matriculaDTO){
        ResponseEntity<Object> novaMatricula = matriculaService.cadastrar(matriculaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMatricula);
        //return new ResponseEntity<>(novaMatricula, HttpStatus.CREATED);
    }

    //Atualizar matrícula
    @PutMapping(path = "/{id}")
    public MatriculaModel atualizarMatricula(@PathVariable Long id, @RequestBody MatriculaModel matriculaModel){
        return matriculaService.alterar(id, matriculaModel);
    }

    //Ver matrícula
    @GetMapping
    public ResponseEntity<List<MatriculaModel>> listarTodas(){ return ResponseEntity.ok(matriculaService.listarTodas());}

    //Deletar matrícula
    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id) {matriculaService.deletar(id);}
}
