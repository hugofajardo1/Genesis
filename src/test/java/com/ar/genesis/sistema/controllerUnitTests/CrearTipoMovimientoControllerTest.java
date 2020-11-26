package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.exception.TipoMovimientoExisteException;
import com.ar.genesis.sistema.core.input.ICrearTipoMovimientoInput;
import com.ar.genesis.sistema.service.controller.CrearTipoMovimientoController;
import com.ar.genesis.sistema.service.dto.TipoMovimientoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CrearTipoMovimientoControllerTest {
    @Mock
    ICrearTipoMovimientoInput iCrearTipoMovimientoInput;

    @Test
    public  void crearTipoMovimiento_TipoMovimientoNoExiste_Devuelve200() throws TipoMovimientoExisteException {
        TipoMovimientoDTO TipoMovimientoDTO = new TipoMovimientoDTO(1, "Factura A");
        when(iCrearTipoMovimientoInput.crearTipoMovimiento(any(TipoMovimiento.class))).thenReturn(true);

        CrearTipoMovimientoController crearTipoMovimientoController = new CrearTipoMovimientoController(iCrearTipoMovimientoInput);
        ResponseEntity<?> responseEntity = crearTipoMovimientoController.crearTipoMovimiento(TipoMovimientoDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoMovimiento_TipoMovimientoExiste_Devuelve412() throws TipoMovimientoExisteException {
        TipoMovimientoDTO TipoMovimientoDTO = new TipoMovimientoDTO(1, "Factura A");
        when(iCrearTipoMovimientoInput.crearTipoMovimiento(any(TipoMovimiento.class))).thenThrow(TipoMovimientoExisteException.class);

        CrearTipoMovimientoController crearTipoMovimientoController = new CrearTipoMovimientoController(iCrearTipoMovimientoInput);
        ResponseEntity<?> responseEntity = crearTipoMovimientoController.crearTipoMovimiento(TipoMovimientoDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
