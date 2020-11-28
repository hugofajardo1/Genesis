package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.core.input.IModificarTipoIvaInput;
import com.ar.genesis.sistema.service.controller.ModificarTipoIvaController;
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
public class ModificarTipoIvaControllerTest {
    @Mock
    IModificarTipoIvaInput modificarTipoIvaInput;

    @Test
    public  void modificarTipoIva_TipoIvaNoExiste_Devuelve200() throws TipoIvaExisteException {
        TipoIvaDTO tipoIvaDTO = new TipoIvaDTO(1, "Responsable Inscripto");
        when(modificarTipoIvaInput.modificarTipoIva(any(TipoIva.class))).thenReturn(true);

        ModificarTipoIvaController modificarTipoIvaController = new ModificarTipoIvaController(modificarTipoIvaInput);
        ResponseEntity<?> responseEntity = modificarTipoIvaController.modificarTipoIva(tipoIvaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarTipoIva_TipoIvaExiste_Devuelve412() throws TipoIvaExisteException {
        TipoIvaDTO tipoIvaDTO = new TipoIvaDTO(1, "Responsable Inscripto");
        when(modificarTipoIvaInput.modificarTipoIva(any(TipoIva.class))).thenThrow(TipoIvaExisteException.class);

        ModificarTipoIvaController modificarTipoIvaController = new ModificarTipoIvaController(modificarTipoIvaInput);
        ResponseEntity<?> responseEntity = modificarTipoIvaController.modificarTipoIva(tipoIvaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

}
