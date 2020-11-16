package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoCliente;
import com.ar.genesis.sistema.core.exception.TipoClienteExisteException;
import com.ar.genesis.sistema.core.input.ICrearTipoClienteInput;
import com.ar.genesis.sistema.service.controller.CrearTipoClienteController;
import com.ar.genesis.sistema.service.dto.TipoClienteDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CrearTipoClienteControllerUnitTest {
    @Mock
    ICrearTipoClienteInput crearTipoClienteInput;

    @Test
    public  void crearTipoCliente_TipoClienteNoExiste_Devuelve200() throws TipoClienteExisteException {
        TipoClienteDTO TipoClienteDTO = new TipoClienteDTO(1, "Cliente");
        when(crearTipoClienteInput.crearTipoCliente(any(TipoCliente.class))).thenReturn(true);

        CrearTipoClienteController crearTipoClienteController = new CrearTipoClienteController(crearTipoClienteInput);
        ResponseEntity<?> responseEntity = crearTipoClienteController.crearTipoCliente(TipoClienteDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearTipoCliente_TipoClienteExiste_Devuelve412() throws TipoClienteExisteException {
        TipoClienteDTO TipoClienteDTO = new TipoClienteDTO(1, "Cliente");
        when(crearTipoClienteInput.crearTipoCliente(any(TipoCliente.class))).thenThrow(TipoClienteExisteException.class);

        CrearTipoClienteController crearTipoClienteController = new CrearTipoClienteController(crearTipoClienteInput);
        ResponseEntity<?> responseEntity = crearTipoClienteController.crearTipoCliente(TipoClienteDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

}
