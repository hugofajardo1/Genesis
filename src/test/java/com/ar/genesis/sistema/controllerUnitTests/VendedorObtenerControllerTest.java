package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Vendedor;
import com.ar.genesis.sistema.core.input.IVendedorObtenerInput;
import com.ar.genesis.sistema.service.controller.VendedorObtenerController;
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
public class VendedorObtenerControllerTest {
    @Mock
    IVendedorObtenerInput miVendedorObtenerInput;

    @Test
    public void obtenerVendedores_VendedoresExisten_Devuelve200(){
        List<Vendedor> vendedores = new ArrayList<>();
        vendedores.add(Vendedor.instancia(1,"Cliente"));
        when(miVendedorObtenerInput.obtenerVendedores()).thenReturn(vendedores);

        VendedorObtenerController vendedorObtenerController = new VendedorObtenerController(miVendedorObtenerInput);
        ResponseEntity<?> responseEntity = vendedorObtenerController.obtenerVendedores();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
}
