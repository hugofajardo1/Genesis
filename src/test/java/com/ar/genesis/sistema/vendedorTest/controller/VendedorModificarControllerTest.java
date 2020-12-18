package com.ar.genesis.sistema.vendedorTest.controller;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.exception.VendedorExisteException;
import com.ar.genesis.sistema.vendedor.core.input.IVendedorModificarInput;
import com.ar.genesis.sistema.vendedor.service.controller.VendedorModificarController;
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
public class VendedorModificarControllerTest {
    @Mock
    IVendedorModificarInput miVendedorModificarInput;

    @Test
    public  void modificarVendedor_VendedorNoExiste_Devuelve200() throws VendedorExisteException {
        VendedorDTO unVendedorDTO = new VendedorDTO(1, "Vendedor 1");
        when(miVendedorModificarInput.modificarVendedor(any(Vendedor.class))).thenReturn(true);

        VendedorModificarController vendedorModificarController = new VendedorModificarController(miVendedorModificarInput);
        ResponseEntity<?> responseEntity = vendedorModificarController.modificarVendedor(unVendedorDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarVendedor_VendedorExiste_Devuelve412() throws VendedorExisteException {
        VendedorDTO unVendedorDTO = new VendedorDTO(1, "Vendedor 1");
        when(miVendedorModificarInput.modificarVendedor(any(Vendedor.class))).thenThrow(VendedorExisteException.class);

        VendedorModificarController vendedorModificarController = new VendedorModificarController(miVendedorModificarInput);
        ResponseEntity<?> responseEntity = vendedorModificarController.modificarVendedor(unVendedorDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
