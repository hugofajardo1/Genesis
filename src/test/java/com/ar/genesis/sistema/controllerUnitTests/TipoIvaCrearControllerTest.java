package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.core.input.ICrearTipoIvaInput;
import com.ar.genesis.sistema.service.controller.TipoIvaCrearController;
import com.ar.genesis.sistema.service.dto.TipoIvaDTO;
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
    ICrearTipoIvaInput miCrearTipoIvaInput;

    @Test
    public  void crearTipoIva_TipoIvaNoExiste_Devuelve200() throws TipoIvaExisteException {
        TipoIvaDTO unTipoIvaDTO = new TipoIvaDTO(1, "Responsable Inscripto");
        when(miCrearTipoIvaInput.crearTipoIva(any(TipoIva.class))).thenReturn(true);

        TipoIvaCrearController tipoIvaCrearController = new TipoIvaCrearController(miCrearTipoIvaInput);
        ResponseEntity<?> responseEntity = tipoIvaCrearController.crearTipoIva(unTipoIvaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoIva_TipoIvaExiste_Devuelve412() throws TipoIvaExisteException {
        TipoIvaDTO unTipoIvaDTO = new TipoIvaDTO(1, "Responsable Inscripto");
        when(miCrearTipoIvaInput.crearTipoIva(any(TipoIva.class))).thenThrow(TipoIvaExisteException.class);

        TipoIvaCrearController tipoIvaCrearController = new TipoIvaCrearController(miCrearTipoIvaInput);
        ResponseEntity<?> responseEntity = tipoIvaCrearController.crearTipoIva(unTipoIvaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
