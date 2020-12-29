package com.ar.genesis.sistema.tipooperacionTest.controller;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.input.ITipoOperacionObtenerInput;
import com.ar.genesis.sistema.tipooperacion.service.controller.TipoOperacionObtenerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class TipoOperacionObtenerControllerTest {
    @Mock
    ITipoOperacionObtenerInput miTipoOperacionObtenerInput;

    @Test
    public void obtenerTipoOperaciones_TipoOperacionesExisten_Devuelve200(){
        List<TipoOperacion> tipoOperaciones = new ArrayList<>();
        tipoOperaciones.add(TipoOperacion.instancia(1,"Cliente"));
        when(miTipoOperacionObtenerInput.obtenerTipoOperaciones()).thenReturn(tipoOperaciones);

        TipoOperacionObtenerController tipoOperacionObtenerController = new TipoOperacionObtenerController(miTipoOperacionObtenerInput);
        ResponseEntity<?> responseEntity = tipoOperacionObtenerController.obtenerTipoOperaciones();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
}
