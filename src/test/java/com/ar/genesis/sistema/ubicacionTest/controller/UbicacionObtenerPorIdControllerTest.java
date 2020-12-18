package com.ar.genesis.sistema.ubicacionTest.controller;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import com.ar.genesis.sistema.ubicacion.core.exception.UbicacionNoExisteException;
import com.ar.genesis.sistema.ubicacion.core.input.IUbicacionObtenerPorIdInput;
import com.ar.genesis.sistema.ubicacion.service.controller.UbicacionObtenerPorIdController;
import com.ar.genesis.sistema.ubicacion.service.dto.UbicacionDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UbicacionObtenerPorIdControllerTest {
    @Mock
    IUbicacionObtenerPorIdInput miUbicacionObtenerPorIdInput;

    @Test
    public void obtenerUbicacionPorId_DevuelveUbicacion() throws UbicacionNoExisteException {
        Ubicacion unUbicacion = Ubicacion.instancia(1,"Ubicacion 1");
        when(miUbicacionObtenerPorIdInput.obtenerUbicacion(1)).thenReturn(unUbicacion);

        UbicacionObtenerPorIdController ubicacionObtenerPorIdController = new UbicacionObtenerPorIdController(miUbicacionObtenerPorIdInput);
        ResponseEntity<?> responseEntity = ubicacionObtenerPorIdController.obtenerUbicacion(1);
        UbicacionDTO resultado = (UbicacionDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerUbicacionPorId_DevuelveNull() throws UbicacionNoExisteException {
        when(miUbicacionObtenerPorIdInput.obtenerUbicacion(1)).thenReturn(null);

        UbicacionObtenerPorIdController ubicacionObtenerPorIdController = new UbicacionObtenerPorIdController(miUbicacionObtenerPorIdInput);
        ResponseEntity<?> responseEntity = ubicacionObtenerPorIdController.obtenerUbicacion(1);
        UbicacionDTO resultado = (UbicacionDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
