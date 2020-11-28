package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.core.input.ICrearUbicacionInput;
import com.ar.genesis.sistema.service.controller.CrearUbicacionController;
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
public class CrearUbicacionControllerTest {
    @Mock
    ICrearUbicacionInput crearUbicacionInput;

    @Test
    public  void crearUbicacion_UbicacionNoExiste_Devuelve200() throws UbicacionExisteException {
        UbicacionDTO ubicacionDTO = new UbicacionDTO(1, "Ubicacion 1");
        when(crearUbicacionInput.crearUbicacion(any(Ubicacion.class))).thenReturn(true);

        CrearUbicacionController crearUbicacionController = new CrearUbicacionController(crearUbicacionInput);
        ResponseEntity<?> responseEntity = crearUbicacionController.crearUbicacion(ubicacionDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearUbicacion_UbicacionExiste_Devuelve412() throws UbicacionExisteException {
        UbicacionDTO ubicacionDTO = new UbicacionDTO(1, "Ubicacion 1");
        when(crearUbicacionInput.crearUbicacion(any(Ubicacion.class))).thenThrow(UbicacionExisteException.class);

        CrearUbicacionController crearUbicacionController = new CrearUbicacionController(crearUbicacionInput);
        ResponseEntity<?> responseEntity = crearUbicacionController.crearUbicacion(ubicacionDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

}
