package com.ar.genesis.sistema.sucursalTest.controller;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.sucursal.core.exception.SucursalExisteException;
import com.ar.genesis.sistema.sucursal.core.input.ISucursalModificarInput;
import com.ar.genesis.sistema.sucursal.service.controller.SucursalModificarController;
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
public class SucursalModificarControllerTest {
    @Mock
    ISucursalModificarInput miSucursalModificarInput;

    @Test
    public  void modificarSucursal_SucursalNoExiste_Devuelve200() throws SucursalExisteException {
        SucursalDTO unaSucursalDTO = new SucursalDTO(1, "Sucursal 1");
        when(miSucursalModificarInput.modificarSucursal(any(Sucursal.class))).thenReturn(true);

        SucursalModificarController sucursalModificarController = new SucursalModificarController(miSucursalModificarInput);
        ResponseEntity<?> responseEntity = sucursalModificarController.modificarSucursal(unaSucursalDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarSucursal_SucursalExiste_Devuelve412() throws SucursalExisteException {
        SucursalDTO unaSucursalDTO = new SucursalDTO(1, "Sucursal 2");
        when(miSucursalModificarInput.modificarSucursal(any(Sucursal.class))).thenThrow(SucursalExisteException.class);

        SucursalModificarController sucursalModificarController = new SucursalModificarController(miSucursalModificarInput);
        ResponseEntity<?> responseEntity = sucursalModificarController.modificarSucursal(unaSucursalDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
