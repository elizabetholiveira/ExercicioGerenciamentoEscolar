package com.exercicio.gerenciamentoEscolar.test;

import com.exercicio.gerenciamentoEscolar.controller.AlunosController;
import com.exercicio.gerenciamentoEscolar.model.AlunosModel;
import com.exercicio.gerenciamentoEscolar.service.AlunosService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringJUnitConfig
//@WebMvcTest(AlunosController.class)
@AutoConfigureMockMvc
@SpringBootTest
public class AlunosControllerTest {

    @MockBean
    private AlunosService alunosService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void  shouldCreateMockMvc(){
        assertNotNull(mockMvc);
    }

    @Test
    public void testCadastrar() throws Exception {
        AlunosModel novoAluno = new AlunosModel(001L, "Maria", "25", "maria@email.com");
        when(alunosService.cadastrar(novoAluno)).thenReturn(novoAluno);
        mockMvc.perform(post("/api/alunos"))
                //.contentType(MediaType.APPLICATION_JSON)
                //.content(new ObjectMapper().writeValueAsString(novoAluno))
                .andExpect(status().isOk());
    }

//    @Test
//    public void testListarTodos() throws Exception{
//        mockMvc.perform(get("/api/alunos"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("api/alunos/list"))
//                .andExpect(model().attributeExists("api/alunos"));
//    }

    @Test
    public void testListarTodos() throws Exception {
        when(alunosService.listarTodos())
                .thenReturn(List.of(new AlunosModel(001L, "Maria", "25", "maria@email.com")));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/alunos"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
