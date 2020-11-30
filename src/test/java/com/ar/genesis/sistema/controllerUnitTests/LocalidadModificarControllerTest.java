package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.exception.LocalidadExisteException;
import com.ar.genesis.sistema.core.input.ILocalidadModificarInput;
import com.ar.genesis.sistema.service.controller.LocalidadModificarController;
import com.ar.genesis.sistema.service.dto.LocalidadDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LocalidadModificarControllerTest {
    @Mock
    ILocalidadModificarInput miLocalidadModificarInput;

    @Test
    public  void modificarLocalidad_LocalidadNoExiste_Devuelve200() throws LocalidadExisteException {
        LocalidadDTO unaLocalidadDTO = new LocalidadDTO(1, "Localidad 1");
        when(miLocalidadModificarInput.modificarLocalidad(any(Localidad.class))).thenReturn(true);

        LocalidadModificarController localidadModificarController = new LocalidadModificarController(miLocalidadModificarInput);
        ResponseEntity<?> responseEntity = localidadModificarController.modificarLocalidad(unaLocalidadDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarLocalidad_LocalidadExiste_Devuelve412() throws LocalidadExisteException {
        LocalidadDTO unaLocalidadDTO = new LocalidadDTO(1, "Localidad 2");
        when(miLocalidadModificarInput.modificarLocalidad(any(Localidad.class))).thenThrow(LocalidadExisteException.class);

        LocalidadModificarController localidadModificarController = new LocalidadModificarController(miLocalidadModificarInput);
        ResponseEntity<?> responseEntity = localidadModificarController.modificarLocalidad(unaLocalidadDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
