package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.TipoIvaNoExisteException;
import com.ar.genesis.sistema.core.input.ITipoIvaObtenerPorIdInput;
import com.ar.genesis.sistema.service.controller.TipoIvaObtenerPorIdController;
import com.ar.genesis.sistema.service.dto.TipoIvaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class TipoIvaObtenerPorIdControllerTest {
    @Mock
    ITipoIvaObtenerPorIdInput miTipoIvaObtenerPorIdInput;

    @Test
    public void obtenerTipoIvaPorId_DevuelveTipoIva() throws TipoIvaNoExisteException {
        TipoIva unTipoIva = TipoIva.instancia(1,"TipoIva 1");
        when(miTipoIvaObtenerPorIdInput.obtenerTipoIva(1)).thenReturn(unTipoIva);

        TipoIvaObtenerPorIdController tipoIvaObtenerPorIdController = new TipoIvaObtenerPorIdController(miTipoIvaObtenerPorIdInput);
        ResponseEntity<?> responseEntity = tipoIvaObtenerPorIdController.obtenerTipoIva(1);
        TipoIvaDTO resultado = (TipoIvaDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerTipoIvaPorId_DevuelveNull() throws TipoIvaNoExisteException {
        when(miTipoIvaObtenerPorIdInput.obtenerTipoIva(1)).thenReturn(null);

        TipoIvaObtenerPorIdController tipoIvaObtenerPorIdController = new TipoIvaObtenerPorIdController(miTipoIvaObtenerPorIdInput);
        ResponseEntity<?> responseEntity = tipoIvaObtenerPorIdController.obtenerTipoIva(1);
        TipoIvaDTO resultado = (TipoIvaDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
