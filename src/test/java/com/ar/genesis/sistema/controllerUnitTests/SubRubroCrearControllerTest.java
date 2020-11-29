package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.exception.SubRubroExisteException;
import com.ar.genesis.sistema.core.input.ICrearSubRubroInput;
import com.ar.genesis.sistema.service.controller.SubRubroCrearController;
import com.ar.genesis.sistema.service.dto.SubRubroDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SubRubroCrearControllerTest {
    @Mock
    ICrearSubRubroInput miCrearSubRubroInput;

    @Test
    public  void crearSubRubro_SubRubroNoExiste_Devuelve200() throws SubRubroExisteException {
        SubRubroDTO unSubRubroDTO = new SubRubroDTO(1, "SubRubro");
        when(miCrearSubRubroInput.crearSubRubro(any(SubRubro.class))).thenReturn(true);

        SubRubroCrearController subRubroCrearController = new SubRubroCrearController(miCrearSubRubroInput);
        ResponseEntity<?> responseEntity = subRubroCrearController.crearSubRubro(unSubRubroDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearSubRubro_SubRubroExiste_Devuelve412() throws SubRubroExisteException {
        SubRubroDTO unSubRubroDTO = new SubRubroDTO(1, "SubRubro");
        when(miCrearSubRubroInput.crearSubRubro(any(SubRubro.class))).thenThrow(SubRubroExisteException.class);

        SubRubroCrearController subRubroCrearController = new SubRubroCrearController(miCrearSubRubroInput);
        ResponseEntity<?> responseEntity = subRubroCrearController.crearSubRubro(unSubRubroDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
