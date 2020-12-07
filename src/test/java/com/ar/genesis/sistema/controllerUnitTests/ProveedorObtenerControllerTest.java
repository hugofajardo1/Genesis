package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Proveedor;
import com.ar.genesis.sistema.core.input.IProveedorObtenerInput;
import com.ar.genesis.sistema.service.controller.ProveedorObtenerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
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
        Assertions.assertEquals(resultado.size(), 1);
    }
}
