package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.input.IObtenerTipoIvasInput;
import com.ar.genesis.sistema.service.controller.ObtenerTipoIvasController;
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
public class TipoIvaObtenerControllerTest {
    @Mock
    IObtenerTipoIvasInput miObtenerTipoIvasInput;

    @Test
    public void obtenerTipoIvas_TipoIvasExisten_Devuelve200(){
        List<TipoIva> tipoIvas = new ArrayList<>();
        tipoIvas.add(TipoIva.instancia(1,"Cliente"));
        when(miObtenerTipoIvasInput.obtenerTipoIvas()).thenReturn(tipoIvas);

        ObtenerTipoIvasController obtenerTipoIvasController = new ObtenerTipoIvasController(miObtenerTipoIvasInput);
        ResponseEntity<?> responseEntity = obtenerTipoIvasController.obtenerTipoIvas();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        if(resultado != null) {
            Assertions.assertEquals(resultado.size(), 1);
        }
    }
}
