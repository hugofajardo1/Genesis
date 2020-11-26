package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.exception.ClienteExisteException;
import com.ar.genesis.sistema.core.input.ICrearClienteInput;
import com.ar.genesis.sistema.service.controller.CrearClienteController;
import com.ar.genesis.sistema.service.dto.ClienteDTO;
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
public class CrearClienteControllerTest {

    @Mock
    ICrearClienteInput crearClienteInput;

    @Test
    public  void crearCliente_ClienteNoExiste_Devuelve200() throws ClienteExisteException {
        ClienteDTO clienteDTO = new ClienteDTO(1, "Fajardo, Hugo Manuel", "Bs As 245", "3825416543", new TipoIvaDTO(1, "Responsable Inscripto"), "20255071336");
        when(crearClienteInput.crearCliente(any(Cliente.class))).thenReturn(true);

        CrearClienteController crearClienteController = new CrearClienteController(crearClienteInput);
        ResponseEntity<?> responseEntity = crearClienteController.crearCliente(clienteDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearCliente_ClienteExiste_Devuelve412() throws ClienteExisteException {
        ClienteDTO clienteDTO = new ClienteDTO(1, "Fajardo, Hugo Manuel", "Bs As 245", "3825416543", new TipoIvaDTO(1, "Responsable Inscripto"), "20255071336");
        when(crearClienteInput.crearCliente(any(Cliente.class))).thenThrow(ClienteExisteException.class);

        CrearClienteController crearClienteController = new CrearClienteController(crearClienteInput);
        ResponseEntity<?> responseEntity = crearClienteController.crearCliente(clienteDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

}
