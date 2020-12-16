package com.ar.genesis.sistema.proveedor.controller;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.exception.ProveedorExisteException;
import com.ar.genesis.sistema.proveedor.core.input.IProveedorModificarInput;
import com.ar.genesis.sistema.proveedor.service.controller.ProveedorModificarController;
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
public class ProveedorModificarControllerTest {
    @Mock
    IProveedorModificarInput miProveedorModificarInput;

    @Test
    public  void modificarProveedor_ProveedorNoExiste_Devuelve200() throws ProveedorExisteException {
        ProveedorDTO unProveedorDTO = new ProveedorDTO(1, "Proveedor 1");
        when(miProveedorModificarInput.modificarProveedor(any(Proveedor.class))).thenReturn(true);

        ProveedorModificarController proveedorModificarController = new ProveedorModificarController(miProveedorModificarInput);
        ResponseEntity<?> responseEntity = proveedorModificarController.modificarProveedor(unProveedorDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarProveedor_ProveedorExiste_Devuelve412() throws ProveedorExisteException {
        ProveedorDTO unProveedorDTO = new ProveedorDTO(1, "Proveedor 1");
        when(miProveedorModificarInput.modificarProveedor(any(Proveedor.class))).thenThrow(ProveedorExisteException.class);

        ProveedorModificarController proveedorModificarController = new ProveedorModificarController(miProveedorModificarInput);
        ResponseEntity<?> responseEntity = proveedorModificarController.modificarProveedor(unProveedorDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
