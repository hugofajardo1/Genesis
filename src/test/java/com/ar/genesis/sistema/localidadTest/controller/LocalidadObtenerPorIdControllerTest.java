package com.ar.genesis.sistema.localidadTest.controller;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.localidad.core.exception.LocalidadNoExisteException;
import com.ar.genesis.sistema.localidad.core.input.ILocalidadObtenerPorIdInput;
import com.ar.genesis.sistema.localidad.service.controller.LocalidadObtenerPorIdController;
import com.ar.genesis.sistema.localidad.service.dto.LocalidadDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class LocalidadObtenerPorIdControllerTest {
    @Mock
    ILocalidadObtenerPorIdInput miLocalidadObtenerPorIdInput;

    @Test
    public void obtenerLocalidadPorId_DevuelveLocalidad() throws LocalidadNoExisteException {
        Localidad unaLocalidad = Localidad.instancia(1,"Localidad 1");
        when(miLocalidadObtenerPorIdInput.obtenerLocalidad(1)).thenReturn(unaLocalidad);

        LocalidadObtenerPorIdController localidadObtenerPorIdController = new LocalidadObtenerPorIdController(miLocalidadObtenerPorIdInput);
        ResponseEntity<?> responseEntity = localidadObtenerPorIdController.obtenerLocalidad(1);
        LocalidadDTO resultado = (LocalidadDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerLocalidadPorId_DevuelveNull() throws LocalidadNoExisteException {
        when(miLocalidadObtenerPorIdInput.obtenerLocalidad(1)).thenReturn(null);

        LocalidadObtenerPorIdController localidadObtenerPorIdController = new LocalidadObtenerPorIdController(miLocalidadObtenerPorIdInput);
        ResponseEntity<?> responseEntity = localidadObtenerPorIdController.obtenerLocalidad(1);
        LocalidadDTO resultado = (LocalidadDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
