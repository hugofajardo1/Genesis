package com.ar.genesis.sistema.tipounidadTest.controller;

import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.tipounidad.core.exception.TipoUnidadExisteException;
import com.ar.genesis.sistema.tipounidad.core.input.ITipoUnidadCrearInput;
import com.ar.genesis.sistema.tipounidad.service.controller.TipoUnidadCrearController;
import com.ar.genesis.sistema.tipounidad.service.dto.TipoUnidadDTO;
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
    ITipoUnidadCrearInput miTipoUnidadCrearInput;

    @Test
    public  void crearTipoUnidad_TipoUnidadNoExiste_Devuelve200() throws TipoUnidadExisteException {
        TipoUnidadDTO unTipoUnidadDTO = new TipoUnidadDTO(1, "Unidad");
        when(miTipoUnidadCrearInput.crearTipoUnidad(any(TipoUnidad.class))).thenReturn(true);

        TipoUnidadCrearController tipoUnidadCrearController = new TipoUnidadCrearController(miTipoUnidadCrearInput);
        ResponseEntity<?> responseEntity = tipoUnidadCrearController.crearTipoUnidad(unTipoUnidadDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoUnidad_TipoUnidadExiste_Devuelve412() throws TipoUnidadExisteException {
        TipoUnidadDTO unTipoUnidadDTO = new TipoUnidadDTO(1, "Unidad");
        when(miTipoUnidadCrearInput.crearTipoUnidad(any(TipoUnidad.class))).thenThrow(TipoUnidadExisteException.class);

        TipoUnidadCrearController tipoUnidadCrearController = new TipoUnidadCrearController(miTipoUnidadCrearInput);
        ResponseEntity<?> responseEntity = tipoUnidadCrearController.crearTipoUnidad(unTipoUnidadDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
