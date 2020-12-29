package com.ar.genesis.sistema.tipooperacionTest.controller;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.exception.TipoOperacionNoExisteException;
import com.ar.genesis.sistema.tipooperacion.core.input.ITipoOperacionObtenerPorIdInput;
import com.ar.genesis.sistema.tipooperacion.service.controller.TipoOperacionObtenerPorIdController;
import com.ar.genesis.sistema.tipooperacion.service.dto.TipoOperacionDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class TipoOperacionObtenerPorIdControllerTest {
    @Mock
    ITipoOperacionObtenerPorIdInput miTipoOperacionObtenerPorIdInput;

    @Test
    public void obtenerTipoOperacionPorId_DevuelveTipoOperacion() throws TipoOperacionNoExisteException {
        TipoOperacion unTipoOperacion = TipoOperacion.instancia(1,"Venta");
        when(miTipoOperacionObtenerPorIdInput.obtenerTipoOperacion(1)).thenReturn(unTipoOperacion);

        TipoOperacionObtenerPorIdController tipoOperacionObtenerPorIdController = new TipoOperacionObtenerPorIdController(miTipoOperacionObtenerPorIdInput);
        ResponseEntity<?> responseEntity = tipoOperacionObtenerPorIdController.obtenerTipoOperacion(1);
        TipoOperacionDTO resultado = (TipoOperacionDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerTipoOperacionPorId_DevuelveNull() throws TipoOperacionNoExisteException {
        when(miTipoOperacionObtenerPorIdInput.obtenerTipoOperacion(1)).thenReturn(null);

        TipoOperacionObtenerPorIdController tipoOperacionObtenerPorIdController = new TipoOperacionObtenerPorIdController(miTipoOperacionObtenerPorIdInput);
        ResponseEntity<?> responseEntity = tipoOperacionObtenerPorIdController.obtenerTipoOperacion(1);
        TipoOperacionDTO resultado = (TipoOperacionDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
