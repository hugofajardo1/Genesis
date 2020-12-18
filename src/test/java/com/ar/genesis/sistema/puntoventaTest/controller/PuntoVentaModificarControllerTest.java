package com.ar.genesis.sistema.puntoventaTest.controller;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.exception.PuntoVentaExisteException;
import com.ar.genesis.sistema.puntoventa.core.input.IPuntoVentaModificarInput;
import com.ar.genesis.sistema.puntoventa.service.controller.PuntoVentaModificarController;
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
public class PuntoVentaModificarControllerTest {
    @Mock
    IPuntoVentaModificarInput miPuntoVentaModificarInput;

    @Test
    public  void modificarPuntoVenta_PuntoVentaNoExiste_Devuelve200() throws PuntoVentaExisteException {
        PuntoVentaDTO unPuntoVentaDTO = new PuntoVentaDTO(1, "PuntoVenta 1", new SucursalDTO(1, "Sucursal 1"), 5);
        when(miPuntoVentaModificarInput.modificarPuntoVenta(any(PuntoVenta.class))).thenReturn(true);

        PuntoVentaModificarController puntoVentaModificarController = new PuntoVentaModificarController(miPuntoVentaModificarInput);
        ResponseEntity<?> responseEntity = puntoVentaModificarController.modificarPuntoVenta(unPuntoVentaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarPuntoVenta_PuntoVentaExiste_Devuelve412() throws PuntoVentaExisteException {
        PuntoVentaDTO unPuntoVentaDTO = new PuntoVentaDTO(1, "PuntoVenta 2", new SucursalDTO(1, "Sucursal 1"), 5);
        when(miPuntoVentaModificarInput.modificarPuntoVenta(any(PuntoVenta.class))).thenThrow(PuntoVentaExisteException.class);

        PuntoVentaModificarController puntoVentaModificarController = new PuntoVentaModificarController(miPuntoVentaModificarInput);
        ResponseEntity<?> responseEntity = puntoVentaModificarController.modificarPuntoVenta(unPuntoVentaDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
