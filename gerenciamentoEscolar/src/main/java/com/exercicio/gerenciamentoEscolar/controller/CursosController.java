package com.exercicio.gerenciamentoEscolar.controller;

import com.exercicio.gerenciamentoEscolar.dto.CursosDTO;
import com.exercicio.gerenciamentoEscolar.service.CursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursosController {

    @Autowired
    CursosService cursosService;

    //Cadastrar curso
    @PostMapping
    public ResponseEntity<CursosDTO> cadastrar(@RequestBody CursosDTO cursosDTO){
        CursosDTO novoCurso = cursosService.cadastrar(cursosDTO);
        return new ResponseEntity<>(novoCurso, HttpStatus.CREATED);
    }

    //Listar cursos
    @GetMapping
    public ResponseEntity<List<CursosDTO>> listarTodos(){ return ResponseEntity.ok(cursosService.listarTodos());}

    //Deletar cursos
    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id){
        cursosService.deletar(id);
        ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso");
    }
}
