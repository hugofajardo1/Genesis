package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.core.input.IModificarUbicacionInput;
import com.ar.genesis.sistema.service.controller.ModificarUbicacionController;
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
public class ModificarUbicacionControllerTest {
    @Mock
    IModificarUbicacionInput modificarUbicacionInput;

    @Test
    public  void crearUbicacion_UbicacionNoExiste_Devuelve200() throws UbicacionExisteException {
        UbicacionDTO UbicacionDTO = new UbicacionDTO(1, "Ubicacion 1");
        when(modificarUbicacionInput.modificarUbicacion(any(Ubicacion.class))).thenReturn(true);

        ModificarUbicacionController modificarUbicacionController = new ModificarUbicacionController(modificarUbicacionInput);
        ResponseEntity<?> responseEntity = modificarUbicacionController.modificarUbicacion(UbicacionDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearUbicacion_UbicacionExiste_Devuelve412() throws UbicacionExisteException {
        UbicacionDTO UbicacionDTO = new UbicacionDTO(1, "Ubicacion 2");
        when(modificarUbicacionInput.modificarUbicacion(any(Ubicacion.class))).thenThrow(UbicacionExisteException.class);

        ModificarUbicacionController modificarUbicacionController = new ModificarUbicacionController(modificarUbicacionInput);
        ResponseEntity<?> responseEntity = modificarUbicacionController.modificarUbicacion(UbicacionDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

}
