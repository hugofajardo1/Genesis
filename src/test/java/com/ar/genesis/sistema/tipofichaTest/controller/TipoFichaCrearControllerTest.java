package com.ar.genesis.sistema.tipofichaTest.controller;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;
import com.ar.genesis.sistema.tipoficha.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.tipoficha.core.input.ITipoFichaCrearInput;
import com.ar.genesis.sistema.tipoficha.service.controller.TipoFichaCrearController;
import com.ar.genesis.sistema.tipoficha.service.dto.TipoFichaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TipoFichaCrearControllerTest {
    @Mock
    ITipoFichaCrearInput miTipoFichaCrearInput;

    @Test
    public  void crearTipoFicha_TipoFichaNoExiste_Devuelve200() throws TipoFichaExisteException {
        TipoFichaDTO unTipoFichaDTO = new TipoFichaDTO(1, "Cliente");
        when(miTipoFichaCrearInput.crearTipoFicha(any(TipoFicha.class))).thenReturn(true);

        TipoFichaCrearController tipoFichaCrearController = new TipoFichaCrearController(miTipoFichaCrearInput);
        ResponseEntity<?> responseEntity = tipoFichaCrearController.crearTipoFicha(unTipoFichaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoFicha_TipoFichaExiste_Devuelve412() throws TipoFichaExisteException {
        TipoFichaDTO unTipoFichaDTO = new TipoFichaDTO(1, "Cliente");
        when(miTipoFichaCrearInput.crearTipoFicha(any(TipoFicha.class))).thenThrow(TipoFichaExisteException.class);

        TipoFichaCrearController tipoFichaCrearController = new TipoFichaCrearController(miTipoFichaCrearInput);
        ResponseEntity<?> responseEntity = tipoFichaCrearController.crearTipoFicha(unTipoFichaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
