package com.ar.genesis.sistema.tipooperacionTest.controller;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.exception.TipoOperacionExisteException;
import com.ar.genesis.sistema.tipooperacion.core.input.ITipoOperacionCrearInput;
import com.ar.genesis.sistema.tipooperacion.service.controller.TipoOperacionCrearController;
import com.ar.genesis.sistema.tipooperacion.service.dto.TipoOperacionDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TipoOperacionCrearControllerTest {
    @Mock
    ITipoOperacionCrearInput miTipoOperacionCrearInput;

    @Test
    public  void crearTipoOperacion_TipoOperacionNoExiste_Devuelve200() throws TipoOperacionExisteException {
        TipoOperacionDTO unTipoOperacionDTO = new TipoOperacionDTO(1, "Ventas");
        when(miTipoOperacionCrearInput.crearTipoOperacion(any(TipoOperacion.class))).thenReturn(true);

        TipoOperacionCrearController tipoOperacionCrearController = new TipoOperacionCrearController(miTipoOperacionCrearInput);
        ResponseEntity<?> responseEntity = tipoOperacionCrearController.crearTipoOperacion(unTipoOperacionDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoOperacion_TipoOperacionExiste_Devuelve412() throws TipoOperacionExisteException {
        TipoOperacionDTO unTipoOperacionDTO = new TipoOperacionDTO(1, "Operacion");
        when(miTipoOperacionCrearInput.crearTipoOperacion(any(TipoOperacion.class))).thenThrow(TipoOperacionExisteException.class);

        TipoOperacionCrearController tipoOperacionCrearController = new TipoOperacionCrearController(miTipoOperacionCrearInput);
        ResponseEntity<?> responseEntity = tipoOperacionCrearController.crearTipoOperacion(unTipoOperacionDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
