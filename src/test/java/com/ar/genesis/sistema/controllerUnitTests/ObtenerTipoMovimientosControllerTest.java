package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.input.IObtenerTipoMovimientosInput;
import com.ar.genesis.sistema.service.controller.ObtenerTipoMovimientosController;
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
public class ObtenerTipoMovimientosControllerTest {
    @Mock
    IObtenerTipoMovimientosInput obtenerTipoMovimientosInput;

    @Test
    public void obtenerTipoMovimientos_TipoMovimientosExisten_Devuelve200(){
        List<TipoMovimiento> losTipoMovimientos = new ArrayList<>();
        losTipoMovimientos.add(TipoMovimiento.instancia(1,"Cliente"));
        when(obtenerTipoMovimientosInput.obtenerTipoMovimientos()).thenReturn(losTipoMovimientos);

        ObtenerTipoMovimientosController obtenerTipoMovimientosController = new ObtenerTipoMovimientosController(obtenerTipoMovimientosInput);
        ResponseEntity<?> responseEntity = obtenerTipoMovimientosController.obtenerTipoMovimientos();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        if(resultado != null) {
            Assertions.assertEquals(resultado.size(), 1);
        }
    }
}
