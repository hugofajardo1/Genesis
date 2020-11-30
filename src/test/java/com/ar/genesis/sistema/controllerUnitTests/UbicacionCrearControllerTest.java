package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.core.input.IUbicacionCrearInput;
import com.ar.genesis.sistema.service.controller.UbicacionCrearController;
import com.ar.genesis.sistema.service.dto.UbicacionDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UbicacionCrearControllerTest {
    @Mock
    IUbicacionCrearInput miUbicacionCrearInput;

    @Test
    public  void crearUbicacion_UbicacionNoExiste_Devuelve200() throws UbicacionExisteException {
        UbicacionDTO unaUbicacionDTO = new UbicacionDTO(1, "Ubicacion 1");
        when(miUbicacionCrearInput.crearUbicacion(any(Ubicacion.class))).thenReturn(true);

        UbicacionCrearController ubicacionCrearController = new UbicacionCrearController(miUbicacionCrearInput);
        ResponseEntity<?> responseEntity = ubicacionCrearController.crearUbicacion(unaUbicacionDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearUbicacion_UbicacionExiste_Devuelve412() throws UbicacionExisteException {
        UbicacionDTO unaUbicacionDTO = new UbicacionDTO(1, "Ubicacion 1");
        when(miUbicacionCrearInput.crearUbicacion(any(Ubicacion.class))).thenThrow(UbicacionExisteException.class);

        UbicacionCrearController ubicacionCrearController = new UbicacionCrearController(miUbicacionCrearInput);
        ResponseEntity<?> responseEntity = ubicacionCrearController.crearUbicacion(unaUbicacionDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
