package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.exception.RubroNoExisteException;
import com.ar.genesis.sistema.core.input.IRubroObtenerPorIdInput;
import com.ar.genesis.sistema.service.controller.RubroObtenerPorIdController;
import com.ar.genesis.sistema.service.dto.RubroDTO;
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
