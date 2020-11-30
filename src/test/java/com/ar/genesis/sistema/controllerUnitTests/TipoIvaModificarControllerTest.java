package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.core.input.ITipoIvaModificarInput;
import com.ar.genesis.sistema.service.controller.TipoIvaModificarController;
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
public class TipoIvaModificarControllerTest {
    @Mock
    ITipoIvaModificarInput miTipoIvaModificarInput;

    @Test
    public  void modificarTipoIva_TipoIvaNoExiste_Devuelve200() throws TipoIvaExisteException {
        TipoIvaDTO unTipoIvaDTO = new TipoIvaDTO(1, "Responsable Inscripto");
        when(miTipoIvaModificarInput.modificarTipoIva(any(TipoIva.class))).thenReturn(true);

        TipoIvaModificarController tipoIvaModificarController = new TipoIvaModificarController(miTipoIvaModificarInput);
        ResponseEntity<?> responseEntity = tipoIvaModificarController.modificarTipoIva(unTipoIvaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarTipoIva_TipoIvaExiste_Devuelve412() throws TipoIvaExisteException {
        TipoIvaDTO unTipoIvaDTO = new TipoIvaDTO(1, "Responsable Inscripto");
        when(miTipoIvaModificarInput.modificarTipoIva(any(TipoIva.class))).thenThrow(TipoIvaExisteException.class);

        TipoIvaModificarController tipoIvaModificarController = new TipoIvaModificarController(miTipoIvaModificarInput);
        ResponseEntity<?> responseEntity = tipoIvaModificarController.modificarTipoIva(unTipoIvaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
