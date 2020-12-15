package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Sucursal;
import com.ar.genesis.sistema.core.exception.SucursalExisteException;
import com.ar.genesis.sistema.core.input.ISucursalCrearInput;
import com.ar.genesis.sistema.service.controller.SucursalCrearController;
import com.ar.genesis.sistema.service.dto.SucursalDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SucursalCrearControllerTest {
    @Mock
    ISucursalCrearInput miSucursalCrearInput;

    @Test
    public  void crearSucursal_SucursalNoExiste_Devuelve200() throws SucursalExisteException {
        SucursalDTO unaSucursalDTO = new SucursalDTO(1, "Sucursal 1");
        when(miSucursalCrearInput.crearSucursal(any(Sucursal.class))).thenReturn(true);

        SucursalCrearController sucursalCrearController = new SucursalCrearController(miSucursalCrearInput);
        ResponseEntity<?> responseEntity = sucursalCrearController.crearSucursal(unaSucursalDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearSucursal_SucursalExiste_Devuelve412() throws SucursalExisteException {
        SucursalDTO unaSucursalDTO = new SucursalDTO(1, "Sucursal 1");
        when(miSucursalCrearInput.crearSucursal(any(Sucursal.class))).thenThrow(SucursalExisteException.class);

        SucursalCrearController sucursalCrearController = new SucursalCrearController(miSucursalCrearInput);
        ResponseEntity<?> responseEntity = sucursalCrearController.crearSucursal(unaSucursalDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
