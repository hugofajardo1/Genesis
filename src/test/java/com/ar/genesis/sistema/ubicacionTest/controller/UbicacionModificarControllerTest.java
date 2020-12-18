package com.ar.genesis.sistema.ubicacionTest.controller;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import com.ar.genesis.sistema.ubicacion.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.ubicacion.core.input.IUbicacionModificarInput;
import com.ar.genesis.sistema.ubicacion.service.controller.UbicacionModificarController;
import com.ar.genesis.sistema.ubicacion.service.dto.UbicacionDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UbicacionModificarControllerTest {
    @Mock
    IUbicacionModificarInput miUbicacionModificarInput;

    @Test
    public  void modificarUbicacion_UbicacionNoExiste_Devuelve200() throws UbicacionExisteException {
        UbicacionDTO unaUbicacionDTO = new UbicacionDTO(1, "Ubicacion 1");
        when(miUbicacionModificarInput.modificarUbicacion(any(Ubicacion.class))).thenReturn(true);

        UbicacionModificarController ubicacionModificarController = new UbicacionModificarController(miUbicacionModificarInput);
        ResponseEntity<?> responseEntity = ubicacionModificarController.modificarUbicacion(unaUbicacionDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarUbicacion_UbicacionExiste_Devuelve412() throws UbicacionExisteException {
        UbicacionDTO unaUbicacionDTO = new UbicacionDTO(1, "Ubicacion 2");
        when(miUbicacionModificarInput.modificarUbicacion(any(Ubicacion.class))).thenThrow(UbicacionExisteException.class);

        UbicacionModificarController ubicacionModificarController = new UbicacionModificarController(miUbicacionModificarInput);
        ResponseEntity<?> responseEntity = ubicacionModificarController.modificarUbicacion(unaUbicacionDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
