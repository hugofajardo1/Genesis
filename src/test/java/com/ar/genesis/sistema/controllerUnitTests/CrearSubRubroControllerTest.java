package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.exception.SubRubroExisteException;
import com.ar.genesis.sistema.core.input.ICrearSubRubroInput;
import com.ar.genesis.sistema.service.controller.CrearSubRubroController;
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
public class CrearSubRubroControllerTest {
    @Mock
    ICrearSubRubroInput miCrearSubRubroInput;

    @Test
    public  void crearSubRubro_SubRubroNoExiste_Devuelve200() throws SubRubroExisteException {
        SubRubroDTO unSubRubroDTO = new SubRubroDTO(1, "SubRubro");
        when(miCrearSubRubroInput.crearSubRubro(any(SubRubro.class))).thenReturn(true);

        CrearSubRubroController crearSubRubroController = new CrearSubRubroController(miCrearSubRubroInput);
        ResponseEntity<?> responseEntity = crearSubRubroController.crearSubRubro(unSubRubroDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearSubRubro_SubRubroExiste_Devuelve412() throws SubRubroExisteException {
        SubRubroDTO unSubRubroDTO = new SubRubroDTO(1, "SubRubro");
        when(miCrearSubRubroInput.crearSubRubro(any(SubRubro.class))).thenThrow(SubRubroExisteException.class);

        CrearSubRubroController crearSubRubroController = new CrearSubRubroController(miCrearSubRubroInput);
        ResponseEntity<?> responseEntity = crearSubRubroController.crearSubRubro(unSubRubroDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
