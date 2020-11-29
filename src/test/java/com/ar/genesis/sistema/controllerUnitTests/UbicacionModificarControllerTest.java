package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.core.input.IModificarUbicacionInput;
import com.ar.genesis.sistema.service.controller.UbicacionModificarController;
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
public class UbicacionModificarControllerTest {
    @Mock
    IModificarUbicacionInput miModificarUbicacionInput;

    @Test
    public  void modificarUbicacion_UbicacionNoExiste_Devuelve200() throws UbicacionExisteException {
        UbicacionDTO unaUbicacionDTO = new UbicacionDTO(1, "Ubicacion 1");
        when(miModificarUbicacionInput.modificarUbicacion(any(Ubicacion.class))).thenReturn(true);

        UbicacionModificarController ubicacionModificarController = new UbicacionModificarController(miModificarUbicacionInput);
        ResponseEntity<?> responseEntity = ubicacionModificarController.modificarUbicacion(unaUbicacionDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarUbicacion_UbicacionExiste_Devuelve412() throws UbicacionExisteException {
        UbicacionDTO unaUbicacionDTO = new UbicacionDTO(1, "Ubicacion 2");
        when(miModificarUbicacionInput.modificarUbicacion(any(Ubicacion.class))).thenThrow(UbicacionExisteException.class);

        UbicacionModificarController ubicacionModificarController = new UbicacionModificarController(miModificarUbicacionInput);
        ResponseEntity<?> responseEntity = ubicacionModificarController.modificarUbicacion(unaUbicacionDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
