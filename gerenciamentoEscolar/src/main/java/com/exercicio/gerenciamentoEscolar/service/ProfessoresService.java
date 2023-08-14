package com.exercicio.gerenciamentoEscolar.service;

import com.exercicio.gerenciamentoEscolar.dto.ProfessoresDTO;
import com.exercicio.gerenciamentoEscolar.model.ProfessoresModel;
import com.exercicio.gerenciamentoEscolar.repository.ProfessoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessoresService {

    @Autowired
    ProfessoresRepository professoresRepository;

    //Cadastrar professores
    public ProfessoresModel cadastrar(ProfessoresModel professoresModel){
        return professoresRepository.save(professoresModel);
    }

    //Listar professores
    public List<ProfessoresModel> listarTodos(){
        return professoresRepository.findAll();
    }

    //Deletar professores
    public void deletar(Long id){
        professoresRepository.deleteById(id);
    }

}
