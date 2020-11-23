package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.core.input.ICrearTipoIvaInput;
import com.ar.genesis.sistema.service.controller.CrearTipoIvaController;
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
public class CrearTipoIvaControllerTest {
    @Mock
    ICrearTipoIvaInput iCrearTipoIvaInput;

    @Test
    public  void crearTipoIva_TipoIvaNoExiste_Devuelve200() throws TipoIvaExisteException {
        TipoIvaDTO TipoIvaDTO = new TipoIvaDTO(1, "Responsable Inscripto");
        when(iCrearTipoIvaInput.crearTipoIva(any(TipoIva.class))).thenReturn(true);

        CrearTipoIvaController crearTipoIvaController = new CrearTipoIvaController(iCrearTipoIvaInput);
        ResponseEntity<?> responseEntity = crearTipoIvaController.crearTipoIva(TipoIvaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoIva_TipoIvaExiste_Devuelve412() throws TipoIvaExisteException {
        TipoIvaDTO TipoIvaDTO = new TipoIvaDTO(1, "Responsable Inscripto");
        when(iCrearTipoIvaInput.crearTipoIva(any(TipoIva.class))).thenThrow(TipoIvaExisteException.class);

        CrearTipoIvaController crearTipoIvaController = new CrearTipoIvaController(iCrearTipoIvaInput);
        ResponseEntity<?> responseEntity = crearTipoIvaController.crearTipoIva(TipoIvaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
