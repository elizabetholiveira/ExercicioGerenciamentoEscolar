package com.exercicio.gerenciamentoEscolar.service;

import com.exercicio.gerenciamentoEscolar.dto.CursosDTO;
import com.exercicio.gerenciamentoEscolar.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursosService {

    @Autowired
    CursosRepository cursosRepository;

    //Cadastrar novo curso
    public CursosDTO cadastrar(CursosDTO cursosDTO){
        return cursosRepository.save(cursosDTO);
    }

    //Listar cursos
    public List<CursosDTO> listarTodos(){
        return cursosRepository.findAll();
    }

    //Deletar cursos
    public void deletar(Long id){
        cursosRepository.deleteById(id);
    }

}
