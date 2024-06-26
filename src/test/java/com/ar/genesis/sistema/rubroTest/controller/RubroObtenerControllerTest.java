package com.ar.genesis.sistema.rubroTest.controller;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.input.IRubroObtenerInput;
import com.ar.genesis.sistema.rubro.service.controller.RubroObtenerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class RubroObtenerControllerTest {
    @Mock
    IRubroObtenerInput miRubroObtenerInput;

    @Test
    public void obtenerRubros_RubrosExisten_Devuelve200(){
        List<Rubro> rubros = new ArrayList<>();
        rubros.add(Rubro.instancia(1,"Rubro  1"));
        when(miRubroObtenerInput.obtenerRubros()).thenReturn(rubros);

        RubroObtenerController rubroObtenerController = new RubroObtenerController(miRubroObtenerInput);
        ResponseEntity<?> responseEntity = rubroObtenerController.obtenerRubros();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
}
