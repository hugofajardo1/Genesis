package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.core.input.ICrearProvinciaInput;
import com.ar.genesis.sistema.service.controller.ProvinciaCrearController;
import com.ar.genesis.sistema.service.dto.ProvinciaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProvinciaCrearControllerTest {
    @Mock
    ICrearProvinciaInput miCrearProvinciaInput;

    @Test
    public  void crearProvincia_ProvinciaNoExiste_Devuelve200() throws ProvinciaExisteException {
        ProvinciaDTO unaProvinciaDTO = new ProvinciaDTO(1, "Provincia");
        when(miCrearProvinciaInput.crearProvincia(any(Provincia.class))).thenReturn(true);

        ProvinciaCrearController provinciaCrearController = new ProvinciaCrearController(miCrearProvinciaInput);
        ResponseEntity<?> responseEntity = provinciaCrearController.crearProvincia(unaProvinciaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearProvincia_ProvinciaExiste_Devuelve412() throws ProvinciaExisteException {
        ProvinciaDTO unaProvinciaDTO = new ProvinciaDTO(1, "Provincia");
        when(miCrearProvinciaInput.crearProvincia(any(Provincia.class))).thenThrow(ProvinciaExisteException.class);

        ProvinciaCrearController provinciaCrearController = new ProvinciaCrearController(miCrearProvinciaInput);
        ResponseEntity<?> responseEntity = provinciaCrearController.crearProvincia(unaProvinciaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}