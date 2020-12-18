package com.ar.genesis.sistema.puntoventaTest.controller;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.input.IPuntoVentaObtenerInput;
import com.ar.genesis.sistema.puntoventa.service.controller.PuntoVentaObtenerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class PuntoVentaObtenerControllerTest {
    @Mock
    IPuntoVentaObtenerInput miPuntoVentaObtenerInput;

    @Test
    public void obtenerPuntoVentas_PuntoVentasExisten_Devuelve200(){
        List<PuntoVenta> puntoventas = new ArrayList<>();
        puntoventas.add(PuntoVenta.instancia(1,"PuntoVenta  1", 5));
        when(miPuntoVentaObtenerInput.obtenerPuntoVentas()).thenReturn(puntoventas);

        PuntoVentaObtenerController puntoventaObtenerController = new PuntoVentaObtenerController(miPuntoVentaObtenerInput);
        ResponseEntity<?> responseEntity = puntoventaObtenerController.obtenerPuntoVentas();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
}
