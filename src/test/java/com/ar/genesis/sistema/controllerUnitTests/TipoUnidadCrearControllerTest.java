package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.exception.TipoUnidadExisteException;
import com.ar.genesis.sistema.core.input.ICrearTipoUnidadInput;
import com.ar.genesis.sistema.service.controller.CrearTipoUnidadController;
import com.ar.genesis.sistema.service.dto.TipoUnidadDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TipoUnidadCrearControllerTest {
    @Mock
    ICrearTipoUnidadInput miCrearTipoUnidadInput;

    @Test
    public  void crearTipoUnidad_TipoUnidadNoExiste_Devuelve200() throws TipoUnidadExisteException {
        TipoUnidadDTO unTipoUnidadDTO = new TipoUnidadDTO(1, "Unidad");
        when(miCrearTipoUnidadInput.crearTipoUnidad(any(TipoUnidad.class))).thenReturn(true);

        CrearTipoUnidadController crearTipoUnidadController = new CrearTipoUnidadController(miCrearTipoUnidadInput);
        ResponseEntity<?> responseEntity = crearTipoUnidadController.crearTipoUnidad(unTipoUnidadDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoUnidad_TipoUnidadExiste_Devuelve412() throws TipoUnidadExisteException {
        TipoUnidadDTO unTipoUnidadDTO = new TipoUnidadDTO(1, "Unidad");
        when(miCrearTipoUnidadInput.crearTipoUnidad(any(TipoUnidad.class))).thenThrow(TipoUnidadExisteException.class);

        CrearTipoUnidadController crearTipoUnidadController = new CrearTipoUnidadController(miCrearTipoUnidadInput);
        ResponseEntity<?> responseEntity = crearTipoUnidadController.crearTipoUnidad(unTipoUnidadDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
