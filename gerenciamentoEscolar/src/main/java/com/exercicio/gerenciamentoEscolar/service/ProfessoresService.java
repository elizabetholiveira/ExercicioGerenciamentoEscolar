package com.exercicio.gerenciamentoEscolar.service;

import com.exercicio.gerenciamentoEscolar.dto.ProfessoresDTO;
import com.exercicio.gerenciamentoEscolar.model.CursosModel;
import com.exercicio.gerenciamentoEscolar.model.ProfessoresModel;
import com.exercicio.gerenciamentoEscolar.repository.CursosRepository;
import com.exercicio.gerenciamentoEscolar.repository.ProfessoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessoresService {

    @Autowired
    ProfessoresRepository professoresRepository;

    @Autowired
    CursosRepository cursosRepository;

    //Cadastrar professores
    public ResponseEntity<Object> cadastrar(ProfessoresDTO professoresDTO){
        Optional<CursosModel> cursosModelOptional = cursosRepository.findById(professoresDTO.getCurso());
        if (cursosModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Curso não encontrado");
        }

        ProfessoresModel professoresModel = new ProfessoresModel();
        professoresModel.setNome(professoresDTO.getNome());
        professoresModel.setIdade(professoresDTO.getIdade());
        professoresModel.setCurso(cursosModelOptional.get());
        professoresModel.setSalario(professoresDTO.getSalario());
        ProfessoresModel professor = professoresRepository.save(professoresModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Professor cadastrado com sucesso!");
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
