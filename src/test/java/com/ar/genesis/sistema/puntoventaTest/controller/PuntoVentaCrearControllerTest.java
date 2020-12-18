package com.ar.genesis.sistema.puntoventaTest.controller;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.exception.PuntoVentaExisteException;
import com.ar.genesis.sistema.puntoventa.core.input.IPuntoVentaCrearInput;

import com.ar.genesis.sistema.puntoventa.service.controller.PuntoVentaCrearController;
import com.ar.genesis.sistema.puntoventa.service.dto.PuntoVentaDTO;
import com.ar.genesis.sistema.sucursal.service.dto.SucursalDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PuntoVentaCrearControllerTest {
    @Mock
    IPuntoVentaCrearInput miPuntoVentaCrearInput;

    @Test
    public  void crearPuntoVenta_PuntoVentaNoExiste_Devuelve200() throws PuntoVentaExisteException {
        PuntoVentaDTO unPuntoVentaDTO = new PuntoVentaDTO(1, "PuntoVenta 1", new SucursalDTO(1, "Sucursal 1"), 5);
        when(miPuntoVentaCrearInput.crearPuntoVenta(any(PuntoVenta.class))).thenReturn(true);

        PuntoVentaCrearController puntoVentaCrearController = new PuntoVentaCrearController(miPuntoVentaCrearInput);
        ResponseEntity<?> responseEntity = puntoVentaCrearController.crearPuntoVenta(unPuntoVentaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearPuntoVenta_PuntoVentaExiste_Devuelve412() throws PuntoVentaExisteException {
        PuntoVentaDTO unPuntoVentaDTO = new PuntoVentaDTO(1, "PuntoVenta 1", new SucursalDTO(1, "Sucursal 1"), 5);
        when(miPuntoVentaCrearInput.crearPuntoVenta(any(PuntoVenta.class))).thenThrow(PuntoVentaExisteException.class);

        PuntoVentaCrearController puntoVentaCrearController = new PuntoVentaCrearController(miPuntoVentaCrearInput);
        ResponseEntity<?> responseEntity = puntoVentaCrearController.crearPuntoVenta(unPuntoVentaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
