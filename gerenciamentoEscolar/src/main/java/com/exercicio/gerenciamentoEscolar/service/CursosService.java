package com.exercicio.gerenciamentoEscolar.service;

import com.exercicio.gerenciamentoEscolar.dto.CursosDTO;
import com.exercicio.gerenciamentoEscolar.model.CursosModel;
import com.exercicio.gerenciamentoEscolar.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursosService {

    @Autowired
    CursosRepository cursosRepository;

    //Cadastrar novo curso
    public CursosModel cadastrar(CursosModel cursosModel){
        return cursosRepository.save(cursosModel);
    }

    //Listar cursos
    public List<CursosModel> listarTodos(){
        return cursosRepository.findAll();
    }

    //Deletar cursos
    public void deletar(Long id){
        cursosRepository.deleteById(id);
    }

}
