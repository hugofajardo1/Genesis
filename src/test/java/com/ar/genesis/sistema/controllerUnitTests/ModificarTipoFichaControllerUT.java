package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.core.input.IModificarTipoFichaInput;
import com.ar.genesis.sistema.service.controller.CrearTipoFichaController;
import com.ar.genesis.sistema.service.controller.ModificarTipoFichaController;
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
public class ModificarTipoFichaControllerUT {
    @Mock
    IModificarTipoFichaInput modificarTipoFichaInput;

    @Test
    public  void crearTipoCliente_TipoClienteNoExiste_Devuelve200() throws TipoFichaExisteException {
        TipoFichaDTO TipoFichaDTO = new TipoFichaDTO(1, "Cliente");
        when(modificarTipoFichaInput.modificarTipoFicha(any(TipoFicha.class))).thenReturn(true);

        ModificarTipoFichaController modificarTipoFichaController = new ModificarTipoFichaController(modificarTipoFichaInput);
        ResponseEntity<?> responseEntity = modificarTipoFichaController.modificarTipoFicha(TipoFichaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoCliente_TipoClienteExiste_Devuelve412() throws TipoFichaExisteException {
        TipoFichaDTO TipoFichaDTO = new TipoFichaDTO(1, "Cliente");
        when(modificarTipoFichaInput.modificarTipoFicha(any(TipoFicha.class))).thenThrow(TipoFichaExisteException.class);

        ModificarTipoFichaController modificarTipoFichaController = new ModificarTipoFichaController(modificarTipoFichaInput);
        ResponseEntity<?> responseEntity = modificarTipoFichaController.modificarTipoFicha(TipoFichaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

}
