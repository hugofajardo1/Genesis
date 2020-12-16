package com.ar.genesis.sistema.proveedor.controller;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.exception.ProveedorExisteException;
import com.ar.genesis.sistema.proveedor.core.input.IProveedorCrearInput;
import com.ar.genesis.sistema.proveedor.service.controller.ProveedorCrearController;
import com.ar.genesis.sistema.proveedor.service.dto.ProveedorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProveedorCrearControllerTest {
    @Mock
    IProveedorCrearInput miProveedorCrearInput;

    @Test
    public  void crearProveedor_ProveedorNoExiste_Devuelve200() throws ProveedorExisteException {
        ProveedorDTO unProveedorDTO = new ProveedorDTO(1, "Proveedor 1");
        when(miProveedorCrearInput.crearProveedor(any(Proveedor.class))).thenReturn(true);

        ProveedorCrearController proveedorCrearController = new ProveedorCrearController(miProveedorCrearInput);
        ResponseEntity<?> responseEntity = proveedorCrearController.crearProveedor(unProveedorDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearProveedor_ProveedorExiste_Devuelve412() throws ProveedorExisteException {
        ProveedorDTO unProveedorDTO = new ProveedorDTO(1, "Proveedor 1");
        when(miProveedorCrearInput.crearProveedor(any(Proveedor.class))).thenThrow(ProveedorExisteException.class);

        ProveedorCrearController proveedorCrearController = new ProveedorCrearController(miProveedorCrearInput);
        ResponseEntity<?> responseEntity = proveedorCrearController.crearProveedor(unProveedorDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
