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
    IModificarUbicacionInput miModificarUbicacionInput;

    @Test
    public  void modificarUbicacion_UbicacionNoExiste_Devuelve200() throws UbicacionExisteException {
        UbicacionDTO ubicacionDTO = new UbicacionDTO(1, "Ubicacion 1");
        when(miModificarUbicacionInput.modificarUbicacion(any(Ubicacion.class))).thenReturn(true);

        ModificarUbicacionController modificarUbicacionController = new ModificarUbicacionController(miModificarUbicacionInput);
        ResponseEntity<?> responseEntity = modificarUbicacionController.modificarUbicacion(ubicacionDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarUbicacion_UbicacionExiste_Devuelve412() throws UbicacionExisteException {
        UbicacionDTO ubicacionDTO = new UbicacionDTO(1, "Ubicacion 2");
        when(miModificarUbicacionInput.modificarUbicacion(any(Ubicacion.class))).thenThrow(UbicacionExisteException.class);

        ModificarUbicacionController modificarUbicacionController = new ModificarUbicacionController(miModificarUbicacionInput);
        ResponseEntity<?> responseEntity = modificarUbicacionController.modificarUbicacion(ubicacionDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
