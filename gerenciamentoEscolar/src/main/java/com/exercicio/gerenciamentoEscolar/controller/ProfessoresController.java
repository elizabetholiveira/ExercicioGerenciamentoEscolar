package com.exercicio.gerenciamentoEscolar.controller;

import com.exercicio.gerenciamentoEscolar.dto.ProfessoresDTO;
import com.exercicio.gerenciamentoEscolar.model.ProfessoresModel;
import com.exercicio.gerenciamentoEscolar.service.ProfessoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
public class ProfessoresController {

    @Autowired
    ProfessoresService professoresService;

    //Cadastrar professor
    @PostMapping
    public ResponseEntity<ResponseEntity> cadastrar(@RequestBody ProfessoresDTO professoresDTO){
        ResponseEntity novoProfessor = professoresService.cadastrar(professoresDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfessor);
    }

    //Listar professores
    @GetMapping
    public ResponseEntity<List<ProfessoresModel>> listarTodos(){
        return ResponseEntity.ok(professoresService.listarTodos());
    }

    //Deletar professor
    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id){
        professoresService.deletar(id);
        ResponseEntity.status(HttpStatus.OK).body("Professor deletado com sucesso");
    }

}
