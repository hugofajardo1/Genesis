package com.ar.genesis.sistema.localidad.controller;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.localidad.core.exception.LocalidadExisteException;
import com.ar.genesis.sistema.localidad.core.input.ILocalidadCrearInput;
import com.ar.genesis.sistema.localidad.service.controller.LocalidadCrearController;
import com.ar.genesis.sistema.localidad.service.dto.LocalidadDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LocalidadCrearControllerTest {
    @Mock
    ILocalidadCrearInput miLocalidadCrearInput;

    @Test
    public  void crearLocalidad_LocalidadNoExiste_Devuelve200() throws LocalidadExisteException {
        LocalidadDTO unaLocalidadDTO = new LocalidadDTO(1, "Localidad 1");
        when(miLocalidadCrearInput.crearLocalidad(any(Localidad.class))).thenReturn(true);

        LocalidadCrearController localidadCrearController = new LocalidadCrearController(miLocalidadCrearInput);
        ResponseEntity<?> responseEntity = localidadCrearController.crearLocalidad(unaLocalidadDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearLocalidad_LocalidadExiste_Devuelve412() throws LocalidadExisteException {
        LocalidadDTO unaLocalidadDTO = new LocalidadDTO(1, "Localidad 1");
        when(miLocalidadCrearInput.crearLocalidad(any(Localidad.class))).thenThrow(LocalidadExisteException.class);

        LocalidadCrearController localidadCrearController = new LocalidadCrearController(miLocalidadCrearInput);
        ResponseEntity<?> responseEntity = localidadCrearController.crearLocalidad(unaLocalidadDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
