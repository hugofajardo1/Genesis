package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.core.input.ICrearProvinciaInput;
import com.ar.genesis.sistema.service.controller.CrearProvinciaController;
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
public class CrearProvinciaControllerTest {
    @Mock
    ICrearProvinciaInput miCrearProvinciaInput;

    @Test
    public  void crearProvincia_ProvinciaNoExiste_Devuelve200() throws ProvinciaExisteException {
        ProvinciaDTO provinciaDTO = new ProvinciaDTO(1, "Provincia");
        when(miCrearProvinciaInput.crearProvincia(any(Provincia.class))).thenReturn(true);

        CrearProvinciaController crearProvinciaController = new CrearProvinciaController(miCrearProvinciaInput);
        ResponseEntity<?> responseEntity = crearProvinciaController.crearProvincia(provinciaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearProvincia_ProvinciaExiste_Devuelve412() throws ProvinciaExisteException {
        ProvinciaDTO provinciaDTO = new ProvinciaDTO(1, "Provincia");
        when(miCrearProvinciaInput.crearProvincia(any(Provincia.class))).thenThrow(ProvinciaExisteException.class);

        CrearProvinciaController crearProvinciaController = new CrearProvinciaController(miCrearProvinciaInput);
        ResponseEntity<?> responseEntity = crearProvinciaController.crearProvincia(provinciaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
