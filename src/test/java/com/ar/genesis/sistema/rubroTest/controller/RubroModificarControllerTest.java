package com.ar.genesis.sistema.rubroTest.controller;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.exception.RubroExisteException;
import com.ar.genesis.sistema.rubro.core.input.IRubroModificarInput;
import com.ar.genesis.sistema.rubro.service.controller.RubroModificarController;
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
public class RubroModificarControllerTest {
    @Mock
    IRubroModificarInput miRubroModificarInput;

    @Test
    public  void modificarRubro_RubroNoExiste_Devuelve200() throws RubroExisteException {
        RubroDTO unRubroDTO = new RubroDTO(1, "Rubro 1");
        when(miRubroModificarInput.modificarRubro(any(Rubro.class))).thenReturn(true);

        RubroModificarController rubroModificarController = new RubroModificarController(miRubroModificarInput);
        ResponseEntity<?> responseEntity = rubroModificarController.modificarRubro(unRubroDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarRubro_RubroExiste_Devuelve412() throws RubroExisteException {
        RubroDTO unRubroDTO = new RubroDTO(1, "Rubro 2");
        when(miRubroModificarInput.modificarRubro(any(Rubro.class))).thenThrow(RubroExisteException.class);

        RubroModificarController rubroModificarController = new RubroModificarController(miRubroModificarInput);
        ResponseEntity<?> responseEntity = rubroModificarController.modificarRubro(unRubroDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
