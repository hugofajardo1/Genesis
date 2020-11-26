package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.exception.TipoMovimientoExisteException;
import com.ar.genesis.sistema.core.input.IModificarTipoMovimientoInput;
import com.ar.genesis.sistema.service.controller.ModificarTipoMovimientoController;
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
public class ModificarTipoMovimientoControllerTest {
    @Mock
    IModificarTipoMovimientoInput modificarTipoMovimientoInput;

    @Test
    public  void crearTipoMovimiento_TipoMovimientoNoExiste_Devuelve200() throws TipoMovimientoExisteException {
        TipoMovimientoDTO tipoMovimientoDTO = new TipoMovimientoDTO(1, "Factura A");
        when(modificarTipoMovimientoInput.modificarTipoMovimiento(any(TipoMovimiento.class))).thenReturn(true);

        ModificarTipoMovimientoController modificarTipoMovimientoController = new ModificarTipoMovimientoController(modificarTipoMovimientoInput);
        ResponseEntity<?> responseEntity = modificarTipoMovimientoController.modificarTipoMovimiento(tipoMovimientoDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoMovimiento_TipoMovimientoExiste_Devuelve412() throws TipoMovimientoExisteException {
        TipoMovimientoDTO tipoMovimientoDTO = new TipoMovimientoDTO(1, "Factura A");
        when(modificarTipoMovimientoInput.modificarTipoMovimiento(any(TipoMovimiento.class))).thenThrow(TipoMovimientoExisteException.class);

        ModificarTipoMovimientoController modificarTipoMovimientoController = new ModificarTipoMovimientoController(modificarTipoMovimientoInput);
        ResponseEntity<?> responseEntity = modificarTipoMovimientoController.modificarTipoMovimiento(tipoMovimientoDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

}