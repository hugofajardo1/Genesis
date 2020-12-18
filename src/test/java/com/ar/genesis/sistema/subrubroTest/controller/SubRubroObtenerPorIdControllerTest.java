package com.ar.genesis.sistema.subrubroTest.controller;

import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.subrubro.core.exception.SubRubroNoExisteException;
import com.ar.genesis.sistema.subrubro.core.input.ISubRubroObtenerPorIdInput;
import com.ar.genesis.sistema.subrubro.service.controller.SubRubroObtenerPorIdController;
import com.ar.genesis.sistema.subrubro.service.dto.SubRubroDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class SubRubroObtenerPorIdControllerTest {
    @Mock
    ISubRubroObtenerPorIdInput miSubRubroObtenerPorIdInput;

    @Test
    public void obtenerSubRubroPorId_DevuelveSubRubro() throws SubRubroNoExisteException {
        SubRubro unSubRubro = SubRubro.instancia(1,"SubRubro 1");
        when(miSubRubroObtenerPorIdInput.obtenerSubRubro(1)).thenReturn(unSubRubro);

        SubRubroObtenerPorIdController subRubroObtenerPorIdController = new SubRubroObtenerPorIdController(miSubRubroObtenerPorIdInput);
        ResponseEntity<?> responseEntity = subRubroObtenerPorIdController.obtenerSubRubro(1);
        SubRubroDTO resultado = (SubRubroDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerSubRubroPorId_DevuelveNull() throws SubRubroNoExisteException {
        when(miSubRubroObtenerPorIdInput.obtenerSubRubro(1)).thenReturn(null);

        SubRubroObtenerPorIdController subRubroObtenerPorIdController = new SubRubroObtenerPorIdController(miSubRubroObtenerPorIdInput);
        ResponseEntity<?> responseEntity = subRubroObtenerPorIdController.obtenerSubRubro(1);
        SubRubroDTO resultado = (SubRubroDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
