package com.exercicio.gerenciamentoEscolar.test;

import com.exercicio.gerenciamentoEscolar.controller.AlunosController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitConfig
@WebMvcTest(AlunosController.class)
//@AutoConfigureMockMvc
//@SpringBootTest
public class AlunosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testListarTodos() throws Exception{
        mockMvc.perform(get("/api/alunos"))
                .andExpect(status().isOk())
                .andExpect(view().name("api/alunos/list"))
                .andExpect(model().attributeExists("api/alunos"));
    }

}
