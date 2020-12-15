package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Sucursal;
import com.ar.genesis.sistema.core.input.ISucursalObtenerInput;
import com.ar.genesis.sistema.service.controller.SucursalObtenerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class SucursalObtenerControllerTest {
    @Mock
    ISucursalObtenerInput miSucursalObtenerInput;

    @Test
    public void obtenerSucursales_SucursalesExisten_Devuelve200(){
        List<Sucursal> Sucursales = new ArrayList<>();
        Sucursales.add(Sucursal.instancia(1,"Sucursal 1"));
        when(miSucursalObtenerInput.obtenerSucursales()).thenReturn(Sucursales);

        SucursalObtenerController sucursalObtenerController = new SucursalObtenerController(miSucursalObtenerInput);
        ResponseEntity<?> responseEntity = sucursalObtenerController.obtenerSucursales();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertEquals(resultado.size(), 1);
    }
}
