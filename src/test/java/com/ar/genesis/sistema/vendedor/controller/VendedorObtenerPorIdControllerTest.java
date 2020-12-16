package com.ar.genesis.sistema.vendedor.controller;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.exception.VendedorNoExisteException;
import com.ar.genesis.sistema.vendedor.core.input.IVendedorObtenerPorIdInput;
import com.ar.genesis.sistema.vendedor.service.controller.VendedorObtenerPorIdController;
import com.ar.genesis.sistema.vendedor.service.dto.VendedorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class VendedorObtenerPorIdControllerTest {
    @Mock
    IVendedorObtenerPorIdInput miVendedorObtenerPorIdInput;

    @Test
    public void obtenerVendedorPorId_DevuelveVendedor() throws VendedorNoExisteException {
        Vendedor unVendedor = Vendedor.instancia(1,"Vendedor 1");
        when(miVendedorObtenerPorIdInput.obtenerVendedor(1)).thenReturn(unVendedor);

        VendedorObtenerPorIdController vendedorObtenerPorIdController = new VendedorObtenerPorIdController(miVendedorObtenerPorIdInput);
        ResponseEntity<?> responseEntity = vendedorObtenerPorIdController.obtenerVendedor(1);
        VendedorDTO resultado = (VendedorDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerVendedorPorId_DevuelveNull() throws VendedorNoExisteException {
        when(miVendedorObtenerPorIdInput.obtenerVendedor(1)).thenReturn(null);

        VendedorObtenerPorIdController vendedorObtenerPorIdController = new VendedorObtenerPorIdController(miVendedorObtenerPorIdInput);
        ResponseEntity<?> responseEntity = vendedorObtenerPorIdController.obtenerVendedor(1);
        VendedorDTO resultado = (VendedorDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
