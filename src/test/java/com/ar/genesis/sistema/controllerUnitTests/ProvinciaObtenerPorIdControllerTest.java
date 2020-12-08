package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.exception.ProvinciaNoExisteException;
import com.ar.genesis.sistema.core.input.IProvinciaObtenerPorIdInput;
import com.ar.genesis.sistema.service.controller.ProvinciaObtenerPorIdController;
import com.ar.genesis.sistema.service.dto.ProvinciaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ProvinciaObtenerPorIdControllerTest {
    @Mock
    IProvinciaObtenerPorIdInput miProvinciaObtenerPorIdInput;

    @Test
    public void obtenerProvinciaPorId_DevuelveProvincia() throws ProvinciaNoExisteException {
        Provincia unaProvincia = Provincia.instancia(1,"Provincia 1");
        when(miProvinciaObtenerPorIdInput.obtenerProvincia(1)).thenReturn(unaProvincia);

        ProvinciaObtenerPorIdController provinciaObtenerPorIdController = new ProvinciaObtenerPorIdController(miProvinciaObtenerPorIdInput);
        ResponseEntity<?> responseEntity = provinciaObtenerPorIdController.obtenerProvincia(1);
        ProvinciaDTO resultado = (ProvinciaDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerProvinciaPorId_DevuelveNull() throws ProvinciaNoExisteException {
        when(miProvinciaObtenerPorIdInput.obtenerProvincia(1)).thenReturn(null);

        ProvinciaObtenerPorIdController provinciaObtenerPorIdController = new ProvinciaObtenerPorIdController(miProvinciaObtenerPorIdInput);
        ResponseEntity<?> responseEntity = provinciaObtenerPorIdController.obtenerProvincia(1);
        ProvinciaDTO resultado = (ProvinciaDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
