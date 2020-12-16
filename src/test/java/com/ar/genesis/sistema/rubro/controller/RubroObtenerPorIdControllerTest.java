package com.ar.genesis.sistema.rubro.controller;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.exception.RubroNoExisteException;
import com.ar.genesis.sistema.rubro.core.input.IRubroObtenerPorIdInput;
import com.ar.genesis.sistema.rubro.service.controller.RubroObtenerPorIdController;
import com.ar.genesis.sistema.rubro.service.dto.RubroDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class RubroObtenerPorIdControllerTest {
    @Mock
    IRubroObtenerPorIdInput miRubroObtenerPorIdInput;

    @Test
    public void obtenerRubroPorId_DevuelveRubro() throws RubroNoExisteException {
        Rubro unRubro = Rubro.instancia(1,"Rubro 1");
        when(miRubroObtenerPorIdInput.obtenerRubro(1)).thenReturn(unRubro);

        RubroObtenerPorIdController rubroObtenerPorIdController = new RubroObtenerPorIdController(miRubroObtenerPorIdInput);
        ResponseEntity<?> responseEntity = rubroObtenerPorIdController.obtenerRubro(1);
        RubroDTO resultado = (RubroDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerRubroPorId_DevuelveNull() throws RubroNoExisteException {
        when(miRubroObtenerPorIdInput.obtenerRubro(1)).thenReturn(null);

        RubroObtenerPorIdController rubroObtenerPorIdController = new RubroObtenerPorIdController(miRubroObtenerPorIdInput);
        ResponseEntity<?> responseEntity = rubroObtenerPorIdController.obtenerRubro(1);
        RubroDTO resultado = (RubroDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
