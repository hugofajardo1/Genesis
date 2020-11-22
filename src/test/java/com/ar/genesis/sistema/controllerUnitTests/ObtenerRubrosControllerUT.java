package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.input.IObtenerRubrosInput;
import com.ar.genesis.sistema.service.controller.ObtenerRubrosController;
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
public class ObtenerRubrosControllerUT {
    @Mock
    IObtenerRubrosInput obtenerRubrosInput;

    @Test
    public void obtenerRubros_RubrosExisten_Devuelve200(){
        List<Rubro> losRubros = new ArrayList<>();
        losRubros.add(Rubro.instancia(1,"Rubro  1"));
        when(obtenerRubrosInput.obtenerRubros()).thenReturn(losRubros);

        ObtenerRubrosController obtenerRubrosController = new ObtenerRubrosController(obtenerRubrosInput);
        ResponseEntity<?> responseEntity = obtenerRubrosController.obtenerRubros();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        if(resultado != null) {
            Assertions.assertEquals(resultado.size(), 1);
        }
    }
}
