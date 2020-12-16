package com.ar.genesis.sistema.tipounidad.controller;

import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.tipounidad.core.exception.TipoUnidadNoExisteException;
import com.ar.genesis.sistema.tipounidad.core.input.ITipoUnidadObtenerPorIdInput;
import com.ar.genesis.sistema.tipounidad.service.controller.TipoUnidadObtenerPorIdController;
import com.ar.genesis.sistema.tipounidad.service.dto.TipoUnidadDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class TipoUnidadObtenerPorIdControllerTest {
    @Mock
    ITipoUnidadObtenerPorIdInput miTipoUnidadObtenerPorIdInput;

    @Test
    public void obtenerTipoUnidadPorId_DevuelveTipoUnidad() throws TipoUnidadNoExisteException {
        TipoUnidad unTipoUnidad = TipoUnidad.instancia(1,"TipoUnidad 1");
        when(miTipoUnidadObtenerPorIdInput.obtenerTipoUnidad(1)).thenReturn(unTipoUnidad);

        TipoUnidadObtenerPorIdController tipoUnidadObtenerPorIdController = new TipoUnidadObtenerPorIdController(miTipoUnidadObtenerPorIdInput);
        ResponseEntity<?> responseEntity = tipoUnidadObtenerPorIdController.obtenerTipoUnidad(1);
        TipoUnidadDTO resultado = (TipoUnidadDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerTipoUnidadPorId_DevuelveNull() throws TipoUnidadNoExisteException {
        when(miTipoUnidadObtenerPorIdInput.obtenerTipoUnidad(1)).thenReturn(null);

        TipoUnidadObtenerPorIdController tipoUnidadObtenerPorIdController = new TipoUnidadObtenerPorIdController(miTipoUnidadObtenerPorIdInput);
        ResponseEntity<?> responseEntity = tipoUnidadObtenerPorIdController.obtenerTipoUnidad(1);
        TipoUnidadDTO resultado = (TipoUnidadDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
