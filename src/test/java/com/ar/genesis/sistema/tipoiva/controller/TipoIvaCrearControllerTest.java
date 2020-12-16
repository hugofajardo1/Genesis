package com.ar.genesis.sistema.tipoiva.controller;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipoiva.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.tipoiva.core.input.ITipoIvaCrearInput;
import com.ar.genesis.sistema.tipoiva.service.controller.TipoIvaCrearController;
import com.ar.genesis.sistema.tipoiva.service.dto.TipoIvaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TipoIvaCrearControllerTest {
    @Mock
    ITipoIvaCrearInput miTipoIvaCrearInput;

    @Test
    public  void crearTipoIva_TipoIvaNoExiste_Devuelve200() throws TipoIvaExisteException {
        TipoIvaDTO unTipoIvaDTO = new TipoIvaDTO(1, "Responsable Inscripto");
        when(miTipoIvaCrearInput.crearTipoIva(any(TipoIva.class))).thenReturn(true);

        TipoIvaCrearController tipoIvaCrearController = new TipoIvaCrearController(miTipoIvaCrearInput);
        ResponseEntity<?> responseEntity = tipoIvaCrearController.crearTipoIva(unTipoIvaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoIva_TipoIvaExiste_Devuelve412() throws TipoIvaExisteException {
        TipoIvaDTO unTipoIvaDTO = new TipoIvaDTO(1, "Responsable Inscripto");
        when(miTipoIvaCrearInput.crearTipoIva(any(TipoIva.class))).thenThrow(TipoIvaExisteException.class);

        TipoIvaCrearController tipoIvaCrearController = new TipoIvaCrearController(miTipoIvaCrearInput);
        ResponseEntity<?> responseEntity = tipoIvaCrearController.crearTipoIva(unTipoIvaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
