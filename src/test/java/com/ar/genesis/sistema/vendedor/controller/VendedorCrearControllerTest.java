package com.ar.genesis.sistema.vendedor.controller;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.exception.VendedorExisteException;
import com.ar.genesis.sistema.vendedor.core.input.IVendedorCrearInput;
import com.ar.genesis.sistema.vendedor.service.controller.VendedorCrearController;
import com.ar.genesis.sistema.vendedor.service.dto.VendedorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class VendedorCrearControllerTest {
    @Mock
    IVendedorCrearInput miVendedorCrearInput;

    @Test
    public  void crearVendedor_VendedorNoExiste_Devuelve200() throws VendedorExisteException {
        VendedorDTO unVendedorDTO = new VendedorDTO(1, "Vendedor 1");
        when(miVendedorCrearInput.crearVendedor(any(Vendedor.class))).thenReturn(true);

        VendedorCrearController vendedorCrearController = new VendedorCrearController(miVendedorCrearInput);
        ResponseEntity<?> responseEntity = vendedorCrearController.crearVendedor(unVendedorDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearVendedor_VendedorExiste_Devuelve412() throws VendedorExisteException {
        VendedorDTO unVendedorDTO = new VendedorDTO(1, "Vendedor 1");
        when(miVendedorCrearInput.crearVendedor(any(Vendedor.class))).thenThrow(VendedorExisteException.class);

        VendedorCrearController vendedorCrearController = new VendedorCrearController(miVendedorCrearInput);
        ResponseEntity<?> responseEntity = vendedorCrearController.crearVendedor(unVendedorDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
