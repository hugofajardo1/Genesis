package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.input.ITipoMovimientoObtenerInput;
import com.ar.genesis.sistema.service.controller.TipoMovimientoObtenerController;
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
public class TipoMovimientoObtenerControllerTest {
    @Mock
    ITipoMovimientoObtenerInput miTipoMovimientoObtenerInput;

    @Test
    public void obtenerTipoMovimientos_TipoMovimientosExisten_Devuelve200(){
        List<TipoMovimiento> tipoMovimientos = new ArrayList<>();
        tipoMovimientos.add(TipoMovimiento.instancia(1,"Cliente"));
        when(miTipoMovimientoObtenerInput.obtenerTipoMovimientos()).thenReturn(tipoMovimientos);

        TipoMovimientoObtenerController tipoMovimientoObtenerController = new TipoMovimientoObtenerController(miTipoMovimientoObtenerInput);
        ResponseEntity<?> responseEntity = tipoMovimientoObtenerController.obtenerTipoMovimientos();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertEquals(resultado.size(), 1);
    }
}
