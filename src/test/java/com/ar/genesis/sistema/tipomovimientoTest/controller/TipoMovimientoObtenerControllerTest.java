package com.ar.genesis.sistema.tipomovimientoTest.controller;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.core.input.ITipoMovimientoObtenerInput;
import com.ar.genesis.sistema.tipomovimiento.service.controller.TipoMovimientoObtenerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
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
        Assertions.assertNotNull(resultado);
    }
}
