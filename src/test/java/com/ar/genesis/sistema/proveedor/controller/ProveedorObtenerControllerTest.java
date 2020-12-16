package com.ar.genesis.sistema.proveedor.controller;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.input.IProveedorObtenerInput;
import com.ar.genesis.sistema.proveedor.service.controller.ProveedorObtenerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ProveedorObtenerControllerTest {
    @Mock
    IProveedorObtenerInput miProveedorObtenerInput;

    @Test
    public void obtenerProveedores_ProveedoresExisten_Devuelve200(){
        List<Proveedor> proveedores = new ArrayList<>();
        proveedores.add(Proveedor.instancia(1,"Proveedor 1"));
        when(miProveedorObtenerInput.obtenerProveedores()).thenReturn(proveedores);

        ProveedorObtenerController proveedorObtenerController = new ProveedorObtenerController(miProveedorObtenerInput);
        ResponseEntity<?> responseEntity = proveedorObtenerController.obtenerProveedores();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
}
