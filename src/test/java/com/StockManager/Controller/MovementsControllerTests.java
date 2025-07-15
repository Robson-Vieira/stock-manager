package com.StockManager.Controller;

import com.StockManager.Model.Movements;
import com.StockManager.Services.MovementsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MovementsController.class)
public class MovementsControllerTests {

    @MockitoBean
    private MovementsService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveRetornar201QuandoTarefaValida() {

    }

}
