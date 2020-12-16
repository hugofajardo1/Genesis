package com.ar.genesis.sistema.tipoficha.controller;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;
import com.ar.genesis.sistema.tipoficha.core.exception.TipoFichaNoExisteException;
import com.ar.genesis.sistema.tipoficha.core.input.ITipoFichaObtenerPorIdInput;
import com.ar.genesis.sistema.tipoficha.service.controller.TipoFichaObtenerPorIdController;
import com.ar.genesis.sistema.tipoficha.service.dto.TipoFichaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class TipoFichaObtenerPorIdControllerTest {
    @Mock
    ITipoFichaObtenerPorIdInput miTipoFichaObtenerPorIdInput;

    @Test
    public void obtenerTipoFichaPorId_DevuelveTipoFicha() throws TipoFichaNoExisteException {
        TipoFicha unTipoFicha = TipoFicha.instancia(1,"TipoFicha 1");
        when(miTipoFichaObtenerPorIdInput.obtenerTipoFicha(1)).thenReturn(unTipoFicha);

        TipoFichaObtenerPorIdController tipoFichaObtenerPorIdController = new TipoFichaObtenerPorIdController(miTipoFichaObtenerPorIdInput);
        ResponseEntity<?> responseEntity = tipoFichaObtenerPorIdController.obtenerTipoFicha(1);
        TipoFichaDTO resultado = (TipoFichaDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerTipoFichaPorId_DevuelveNull() throws TipoFichaNoExisteException {
        when(miTipoFichaObtenerPorIdInput.obtenerTipoFicha(1)).thenReturn(null);

        TipoFichaObtenerPorIdController tipoFichaObtenerPorIdController = new TipoFichaObtenerPorIdController(miTipoFichaObtenerPorIdInput);
        ResponseEntity<?> responseEntity = tipoFichaObtenerPorIdController.obtenerTipoFicha(1);
        TipoFichaDTO resultado = (TipoFichaDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
