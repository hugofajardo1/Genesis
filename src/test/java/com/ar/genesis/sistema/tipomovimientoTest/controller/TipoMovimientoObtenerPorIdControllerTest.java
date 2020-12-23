package com.ar.genesis.sistema.tipomovimientoTest.controller;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.core.exception.TipoMovimientoNoExisteException;
import com.ar.genesis.sistema.tipomovimiento.core.input.ITipoMovimientoObtenerPorIdInput;
import com.ar.genesis.sistema.tipomovimiento.service.controller.TipoMovimientoObtenerPorIdController;
import com.ar.genesis.sistema.tipomovimiento.service.dto.TipoMovimientoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class TipoMovimientoObtenerPorIdControllerTest {
    @Mock
    ITipoMovimientoObtenerPorIdInput miTipoMovimientoObtenerPorIdInput;

    @Test
    public void obtenerTipoMovimientoPorId_DevuelveTipoMovimiento() throws TipoMovimientoNoExisteException {
        TipoMovimiento unTipoMovimiento = TipoMovimiento.instancia(1,"TipoMovimiento 1", "Debe");
        when(miTipoMovimientoObtenerPorIdInput.obtenerTipoMovimiento(1)).thenReturn(unTipoMovimiento);

        TipoMovimientoObtenerPorIdController tipoMovimientoObtenerPorIdController = new TipoMovimientoObtenerPorIdController(miTipoMovimientoObtenerPorIdInput);
        ResponseEntity<?> responseEntity = tipoMovimientoObtenerPorIdController.obtenerTipoMovimiento(1);
        TipoMovimientoDTO resultado = (TipoMovimientoDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerTipoMovimientoPorId_DevuelveNull() throws TipoMovimientoNoExisteException {
        when(miTipoMovimientoObtenerPorIdInput.obtenerTipoMovimiento(1)).thenReturn(null);

        TipoMovimientoObtenerPorIdController tipoMovimientoObtenerPorIdController = new TipoMovimientoObtenerPorIdController(miTipoMovimientoObtenerPorIdInput);
        ResponseEntity<?> responseEntity = tipoMovimientoObtenerPorIdController.obtenerTipoMovimiento(1);
        TipoMovimientoDTO resultado = (TipoMovimientoDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
