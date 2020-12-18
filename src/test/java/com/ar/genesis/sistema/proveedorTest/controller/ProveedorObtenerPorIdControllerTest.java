package com.ar.genesis.sistema.proveedorTest.controller;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.exception.ProveedorNoExisteException;
import com.ar.genesis.sistema.proveedor.core.input.IProveedorObtenerPorIdInput;
import com.ar.genesis.sistema.proveedor.service.controller.ProveedorObtenerPorIdController;
import com.ar.genesis.sistema.proveedor.service.dto.ProveedorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ProveedorObtenerPorIdControllerTest {
    @Mock
    IProveedorObtenerPorIdInput miProveedorObtenerPorIdInput;

    @Test
    public void obtenerProveedorPorId_DevuelveProveedor() throws ProveedorNoExisteException {
        Proveedor unProveedor = Proveedor.instancia(1,"Proveedor 1");
        when(miProveedorObtenerPorIdInput.obtenerProveedor(1)).thenReturn(unProveedor);

        ProveedorObtenerPorIdController proveedorObtenerPorIdController = new ProveedorObtenerPorIdController(miProveedorObtenerPorIdInput);
        ResponseEntity<?> responseEntity = proveedorObtenerPorIdController.obtenerProveedor(1);
        ProveedorDTO resultado = (ProveedorDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerProveedorPorId_DevuelveNull() throws ProveedorNoExisteException {
        when(miProveedorObtenerPorIdInput.obtenerProveedor(1)).thenReturn(null);

        ProveedorObtenerPorIdController proveedorObtenerPorIdController = new ProveedorObtenerPorIdController(miProveedorObtenerPorIdInput);
        ResponseEntity<?> responseEntity = proveedorObtenerPorIdController.obtenerProveedor(1);
        ProveedorDTO resultado = (ProveedorDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
