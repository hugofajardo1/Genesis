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
public class TipoMovimientoModificarControllerTest {
    @Mock
    IModificarTipoMovimientoInput miModificarTipoMovimientoInput;

    @Test
    public  void modificarTipoMovimiento_TipoMovimientoNoExiste_Devuelve200() throws TipoMovimientoExisteException {
        TipoMovimientoDTO unTipoMovimientoDTO = new TipoMovimientoDTO(1, "Factura A");
        when(miModificarTipoMovimientoInput.modificarTipoMovimiento(any(TipoMovimiento.class))).thenReturn(true);

        ModificarTipoMovimientoController modificarTipoMovimientoController = new ModificarTipoMovimientoController(miModificarTipoMovimientoInput);
        ResponseEntity<?> responseEntity = modificarTipoMovimientoController.modificarTipoMovimiento(unTipoMovimientoDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarTipoMovimiento_TipoMovimientoExiste_Devuelve412() throws TipoMovimientoExisteException {
        TipoMovimientoDTO unTipoMovimientoDTO = new TipoMovimientoDTO(1, "Factura A");
        when(miModificarTipoMovimientoInput.modificarTipoMovimiento(any(TipoMovimiento.class))).thenThrow(TipoMovimientoExisteException.class);

        ModificarTipoMovimientoController modificarTipoMovimientoController = new ModificarTipoMovimientoController(miModificarTipoMovimientoInput);
        ResponseEntity<?> responseEntity = modificarTipoMovimientoController.modificarTipoMovimiento(unTipoMovimientoDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
