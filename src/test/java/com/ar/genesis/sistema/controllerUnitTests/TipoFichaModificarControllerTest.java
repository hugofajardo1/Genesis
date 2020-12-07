package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.core.input.ITipoFichaModificarInput;
import com.ar.genesis.sistema.service.controller.TipoFichaModificarController;
import com.ar.genesis.sistema.service.dto.TipoFichaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TipoFichaModificarControllerTest {
    @Mock
    ITipoFichaModificarInput miTipoFichaModificarInput;

    @Test
    public  void modificarTipoFicha_TipoFichaNoExiste_Devuelve200() throws TipoFichaExisteException {
        TipoFichaDTO unTipoFichaDTO = new TipoFichaDTO(1, "Cliente");
        when(miTipoFichaModificarInput.modificarTipoFicha(any(TipoFicha.class))).thenReturn(true);

        TipoFichaModificarController tipoFichaModificarController = new TipoFichaModificarController(miTipoFichaModificarInput);
        ResponseEntity<?> responseEntity = tipoFichaModificarController.modificarTipoFicha(unTipoFichaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarTipoFicha_TipoFichaExiste_Devuelve412() throws TipoFichaExisteException {
        TipoFichaDTO unTipoFichaDTO = new TipoFichaDTO(1, "Cliente");
        when(miTipoFichaModificarInput.modificarTipoFicha(any(TipoFicha.class))).thenThrow(TipoFichaExisteException.class);

        TipoFichaModificarController tipoFichaModificarController = new TipoFichaModificarController(miTipoFichaModificarInput);
        ResponseEntity<?> responseEntity = tipoFichaModificarController.modificarTipoFicha(unTipoFichaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
