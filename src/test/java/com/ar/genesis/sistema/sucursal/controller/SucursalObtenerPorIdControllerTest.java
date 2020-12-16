package com.ar.genesis.sistema.sucursal.controller;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.sucursal.core.exception.SucursalNoExisteException;
import com.ar.genesis.sistema.sucursal.core.input.ISucursalObtenerPorIdInput;
import com.ar.genesis.sistema.sucursal.service.controller.SucursalObtenerPorIdController;
import com.ar.genesis.sistema.sucursal.service.dto.SucursalDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class SucursalObtenerPorIdControllerTest {
    @Mock
    ISucursalObtenerPorIdInput miSucursalObtenerPorIdInput;

    @Test
    public void obtenerSucursalPorId_DevuelveSucursal() throws SucursalNoExisteException {
        Sucursal unSucursal = Sucursal.instancia(1,"Sucursal 1");
        when(miSucursalObtenerPorIdInput.obtenerSucursal(1)).thenReturn(unSucursal);

        SucursalObtenerPorIdController sucursalObtenerPorIdController = new SucursalObtenerPorIdController(miSucursalObtenerPorIdInput);
        ResponseEntity<?> responseEntity = sucursalObtenerPorIdController.obtenerSucursal(1);
        SucursalDTO resultado = (SucursalDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerSucursalPorId_DevuelveNull() throws SucursalNoExisteException {
        when(miSucursalObtenerPorIdInput.obtenerSucursal(1)).thenReturn(null);

        SucursalObtenerPorIdController sucursalObtenerPorIdController = new SucursalObtenerPorIdController(miSucursalObtenerPorIdInput);
        ResponseEntity<?> responseEntity = sucursalObtenerPorIdController.obtenerSucursal(1);
        SucursalDTO resultado = (SucursalDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
