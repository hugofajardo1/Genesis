package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.core.input.ICrearTipoFichaInput;
import com.ar.genesis.sistema.service.controller.CrearTipoFichaController;
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
public class CrearTipoFichaControllerUT {
    @Mock
    ICrearTipoFichaInput crearTipoClienteInput;

    @Test
    public  void crearTipoCliente_TipoClienteNoExiste_Devuelve200() throws TipoFichaExisteException {
        TipoFichaDTO TipoFichaDTO = new TipoFichaDTO(1, "Cliente");
        when(crearTipoClienteInput.crearTipoFicha(any(TipoFicha.class))).thenReturn(true);

        CrearTipoFichaController crearTipoFichaController = new CrearTipoFichaController(crearTipoClienteInput);
        ResponseEntity<?> responseEntity = crearTipoFichaController.crearTipoFicha(TipoFichaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoCliente_TipoClienteExiste_Devuelve412() throws TipoFichaExisteException {
        TipoFichaDTO TipoFichaDTO = new TipoFichaDTO(1, "Cliente");
        when(crearTipoClienteInput.crearTipoFicha(any(TipoFicha.class))).thenThrow(TipoFichaExisteException.class);

        CrearTipoFichaController crearTipoFichaController = new CrearTipoFichaController(crearTipoClienteInput);
        ResponseEntity<?> responseEntity = crearTipoFichaController.crearTipoFicha(TipoFichaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

}
