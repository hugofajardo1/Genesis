package com.ar.genesis.sistema.puntoventaTest.controller;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.exception.PuntoVentaNoExisteException;
import com.ar.genesis.sistema.puntoventa.core.input.IPuntoVentaObtenerPorIdInput;
import com.ar.genesis.sistema.puntoventa.service.controller.PuntoVentaObtenerPorIdController;
import com.ar.genesis.sistema.puntoventa.service.dto.PuntoVentaDTO;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class PuntoVentaObtenerPorIdControllerTest {
    @Mock
    IPuntoVentaObtenerPorIdInput miPuntoVentaObtenerPorIdInput;

    @Test
    public void obtenerPuntoVentaPorId_DevuelvePuntoVenta() throws PuntoVentaNoExisteException {
        PuntoVenta unPuntoVenta = PuntoVenta.instancia(1,"PuntoVenta 1", Sucursal.instancia(1, "Sucursal 1"), 5);
        when(miPuntoVentaObtenerPorIdInput.obtenerPuntoVenta(1)).thenReturn(unPuntoVenta);

        PuntoVentaObtenerPorIdController puntoventaObtenerPorIdController = new PuntoVentaObtenerPorIdController(miPuntoVentaObtenerPorIdInput);
        ResponseEntity<?> responseEntity = puntoventaObtenerPorIdController.obtenerPuntoVenta(1);
        PuntoVentaDTO resultado = (PuntoVentaDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerPuntoVentaPorId_DevuelveNull() throws PuntoVentaNoExisteException {
        when(miPuntoVentaObtenerPorIdInput.obtenerPuntoVenta(1)).thenReturn(null);

        PuntoVentaObtenerPorIdController puntoventaObtenerPorIdController = new PuntoVentaObtenerPorIdController(miPuntoVentaObtenerPorIdInput);
        ResponseEntity<?> responseEntity = puntoventaObtenerPorIdController.obtenerPuntoVenta(1);
        PuntoVentaDTO resultado = (PuntoVentaDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
