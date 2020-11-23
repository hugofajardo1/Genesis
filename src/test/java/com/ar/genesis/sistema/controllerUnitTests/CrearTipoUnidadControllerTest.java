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
public class CrearTipoUnidadControllerTest {
    @Mock
    ICrearTipoUnidadInput iCrearTipoUnidadInput;

    @Test
    public  void crearTipoUnidad_TipoUnidadNoExiste_Devuelve200() throws TipoUnidadExisteException {
        TipoUnidadDTO TipoUnidadDTO = new TipoUnidadDTO(1, "Unidad");
        when(iCrearTipoUnidadInput.crearTipoUnidad(any(TipoUnidad.class))).thenReturn(true);

        CrearTipoUnidadController crearTipoUnidadController = new CrearTipoUnidadController(iCrearTipoUnidadInput);
        ResponseEntity<?> responseEntity = crearTipoUnidadController.crearTipoUnidad(TipoUnidadDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoUnidad_TipoUnidadExiste_Devuelve412() throws TipoUnidadExisteException {
        TipoUnidadDTO TipoUnidadDTO = new TipoUnidadDTO(1, "Unidad");
        when(iCrearTipoUnidadInput.crearTipoUnidad(any(TipoUnidad.class))).thenThrow(TipoUnidadExisteException.class);

        CrearTipoUnidadController crearTipoUnidadController = new CrearTipoUnidadController(iCrearTipoUnidadInput);
        ResponseEntity<?> responseEntity = crearTipoUnidadController.crearTipoUnidad(TipoUnidadDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}