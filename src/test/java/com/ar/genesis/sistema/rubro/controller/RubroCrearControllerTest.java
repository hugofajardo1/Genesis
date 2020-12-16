package com.ar.genesis.sistema.rubro.controller;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.exception.RubroExisteException;
import com.ar.genesis.sistema.rubro.core.input.IRubroCrearInput;
import com.ar.genesis.sistema.rubro.service.controller.RubroCrearController;
import com.ar.genesis.sistema.rubro.service.dto.RubroDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RubroCrearControllerTest {
    @Mock
    IRubroCrearInput miRubroCrearInput;

    @Test
    public  void crearRubro_RubroNoExiste_Devuelve200() throws RubroExisteException {
        RubroDTO unRubroDTO = new RubroDTO(1, "Rubro");
        when(miRubroCrearInput.crearRubro(any(Rubro.class))).thenReturn(true);

        RubroCrearController rubroCrearController = new RubroCrearController(miRubroCrearInput);
        ResponseEntity<?> responseEntity = rubroCrearController.crearRubro(unRubroDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearRubro_RubroExiste_Devuelve412() throws RubroExisteException {
        RubroDTO unRubroDTO = new RubroDTO(1, "Rubro");
        when(miRubroCrearInput.crearRubro(any(Rubro.class))).thenThrow(RubroExisteException.class);

        RubroCrearController rubroCrearController = new RubroCrearController(miRubroCrearInput);
        ResponseEntity<?> responseEntity = rubroCrearController.crearRubro(unRubroDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
