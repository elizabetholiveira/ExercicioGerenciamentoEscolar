package com.exercicio.gerenciamentoEscolar.test;

//import com.exercicio.gerenciamentoEscolar.controller.AlunosController;
import com.exercicio.gerenciamentoEscolar.controller.AlunosController;
import com.exercicio.gerenciamentoEscolar.model.AlunosModel;
import com.exercicio.gerenciamentoEscolar.service.AlunosService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.when;
////import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
////import static org.springframework.test.web.servlet.ResultActions;
//
//import java.util.List;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.exercicio.gerenciamentoEscolar.service.MatriculaService;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;

//--

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import java.util.Optional;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//--

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


//@SpringJUnitConfig
//@WebMvcTest(AlunosController.class)
//@AutoConfigureMockMvc
//@SpringBootTest
@WebMvcTest(controllers = AlunosController.class)
public class AlunosControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AlunosService alunosService;

    @MockBean
    private MatriculaService matriculaService;

    @Test
    public void testListarTodos() throws Exception {
        mockMvc.perform(get("/api/alunos"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCadastrar() throws Exception {
        AlunosModel alunosModel = new AlunosModel(001L, "Maria", "25", "maria@email.com");
        when(alunosService.cadastrar(alunosModel))
                .thenReturn(new AlunosModel(001L, "Maria", "25", "maria@email.com"));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/alunos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(alunosModel)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(alunosModel)))
                .andDo(print());
    }
}
