package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.input.IObtenerSubRubrosInput;
import com.ar.genesis.sistema.service.controller.SubRubroObtenerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class SubRubroObtenerControllerTest {
    @Mock
    IObtenerSubRubrosInput miObtenerSubRubrosInput;

    @Test
    public void obtenerSubRubros_SubRubrosExisten_Devuelve200(){
        List<SubRubro> subRubros = new ArrayList<>();
        subRubros.add(SubRubro.instancia(1,"SubRubro  1"));
        when(miObtenerSubRubrosInput.obtenerSubRubros()).thenReturn(subRubros);

        SubRubroObtenerController subRubroObtenerController = new SubRubroObtenerController(miObtenerSubRubrosInput);
        ResponseEntity<?> responseEntity = subRubroObtenerController.obtenerSubRubros();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        if(resultado != null) {
            Assertions.assertEquals(resultado.size(), 1);
        }
    }
}
