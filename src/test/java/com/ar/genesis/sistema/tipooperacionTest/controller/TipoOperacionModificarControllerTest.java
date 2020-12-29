package com.ar.genesis.sistema.tipooperacionTest.controller;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.exception.TipoOperacionExisteException;
import com.ar.genesis.sistema.tipooperacion.core.input.ITipoOperacionModificarInput;
import com.ar.genesis.sistema.tipooperacion.service.controller.TipoOperacionModificarController;
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
public class TipoOperacionModificarControllerTest {
    @Mock
    ITipoOperacionModificarInput miTipoOperacionModificarInput;

    @Test
    public  void modificarTipoOperacion_TipoOperacionNoExiste_Devuelve200() throws TipoOperacionExisteException {
        TipoOperacionDTO unTipoOperacionDTO = new TipoOperacionDTO(1, "Venta");
        when(miTipoOperacionModificarInput.modificarTipoOperacion(any(TipoOperacion.class))).thenReturn(true);

        TipoOperacionModificarController tipoOperacionModificarController = new TipoOperacionModificarController(miTipoOperacionModificarInput);
        ResponseEntity<?> responseEntity = tipoOperacionModificarController.modificarTipoOperacion(unTipoOperacionDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarTipoOperacion_TipoOperacionExiste_Devuelve412() throws TipoOperacionExisteException {
        TipoOperacionDTO unTipoOperacionDTO = new TipoOperacionDTO(1, "Venta");
        when(miTipoOperacionModificarInput.modificarTipoOperacion(any(TipoOperacion.class))).thenThrow(TipoOperacionExisteException.class);

        TipoOperacionModificarController tipoOperacionModificarController = new TipoOperacionModificarController(miTipoOperacionModificarInput);
        ResponseEntity<?> responseEntity = tipoOperacionModificarController.modificarTipoOperacion(unTipoOperacionDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
