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
    ICrearUbicacionInput crearTipoClienteInput;

    @Test
    public  void crearTipoCliente_TipoClienteNoExiste_Devuelve200() throws UbicacionExisteException {
        UbicacionDTO UbicacionDTO = new UbicacionDTO(1, "Ubicacion 1");
        when(crearTipoClienteInput.crearUbicacion(any(Ubicacion.class))).thenReturn(true);

        CrearUbicacionController crearUbicacionController = new CrearUbicacionController(crearTipoClienteInput);
        ResponseEntity<?> responseEntity = crearUbicacionController.crearUbicacion(UbicacionDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoCliente_TipoClienteExiste_Devuelve412() throws UbicacionExisteException {
        UbicacionDTO UbicacionDTO = new UbicacionDTO(1, "Ubicacion 1");
        when(crearTipoClienteInput.crearUbicacion(any(Ubicacion.class))).thenThrow(UbicacionExisteException.class);

        CrearUbicacionController crearUbicacionController = new CrearUbicacionController(crearTipoClienteInput);
        ResponseEntity<?> responseEntity = crearUbicacionController.crearUbicacion(UbicacionDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

}
