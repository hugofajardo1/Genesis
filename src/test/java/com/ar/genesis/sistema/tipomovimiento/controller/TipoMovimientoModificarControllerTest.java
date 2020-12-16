package com.ar.genesis.sistema.tipomovimiento.controller;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.core.exception.TipoMovimientoExisteException;
import com.ar.genesis.sistema.tipomovimiento.core.input.ITipoMovimientoModificarInput;
import com.ar.genesis.sistema.tipomovimiento.service.controller.TipoMovimientoModificarController;
import com.ar.genesis.sistema.tipomovimiento.service.dto.TipoMovimientoDTO;
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
    ITipoMovimientoModificarInput miTipoMovimientoModificarInput;

    @Test
    public  void modificarTipoMovimiento_TipoMovimientoNoExiste_Devuelve200() throws TipoMovimientoExisteException {
        TipoMovimientoDTO unTipoMovimientoDTO = new TipoMovimientoDTO(1, "Factura A");
        when(miTipoMovimientoModificarInput.modificarTipoMovimiento(any(TipoMovimiento.class))).thenReturn(true);

        TipoMovimientoModificarController tipoMovimientoModificarController = new TipoMovimientoModificarController(miTipoMovimientoModificarInput);
        ResponseEntity<?> responseEntity = tipoMovimientoModificarController.modificarTipoMovimiento(unTipoMovimientoDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarTipoMovimiento_TipoMovimientoExiste_Devuelve412() throws TipoMovimientoExisteException {
        TipoMovimientoDTO unTipoMovimientoDTO = new TipoMovimientoDTO(1, "Factura A");
        when(miTipoMovimientoModificarInput.modificarTipoMovimiento(any(TipoMovimiento.class))).thenThrow(TipoMovimientoExisteException.class);

        TipoMovimientoModificarController tipoMovimientoModificarController = new TipoMovimientoModificarController(miTipoMovimientoModificarInput);
        ResponseEntity<?> responseEntity = tipoMovimientoModificarController.modificarTipoMovimiento(unTipoMovimientoDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
