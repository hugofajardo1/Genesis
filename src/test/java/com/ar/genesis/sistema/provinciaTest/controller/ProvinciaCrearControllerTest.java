package com.ar.genesis.sistema.provinciaTest.controller;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.provincia.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.provincia.core.input.IProvinciaCrearInput;
import com.ar.genesis.sistema.provincia.service.controller.ProvinciaCrearController;
import com.ar.genesis.sistema.provincia.service.dto.ProvinciaDTO;
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
    IProvinciaCrearInput miProvinciaCrearInput;

    @Test
    public  void crearProvincia_ProvinciaNoExiste_Devuelve200() throws ProvinciaExisteException {
        ProvinciaDTO unaProvinciaDTO = new ProvinciaDTO(1, "Provincia");
        when(miProvinciaCrearInput.crearProvincia(any(Provincia.class))).thenReturn(true);

        ProvinciaCrearController provinciaCrearController = new ProvinciaCrearController(miProvinciaCrearInput);
        ResponseEntity<?> responseEntity = provinciaCrearController.crearProvincia(unaProvinciaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearProvincia_ProvinciaExiste_Devuelve412() throws ProvinciaExisteException {
        ProvinciaDTO unaProvinciaDTO = new ProvinciaDTO(1, "Provincia");
        when(miProvinciaCrearInput.crearProvincia(any(Provincia.class))).thenThrow(ProvinciaExisteException.class);

        ProvinciaCrearController provinciaCrearController = new ProvinciaCrearController(miProvinciaCrearInput);
        ResponseEntity<?> responseEntity = provinciaCrearController.crearProvincia(unaProvinciaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
