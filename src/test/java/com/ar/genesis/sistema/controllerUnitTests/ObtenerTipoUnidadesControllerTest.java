package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.input.IObtenerTipoUnidadesInput;
import com.ar.genesis.sistema.service.controller.ObtenerTipoUnidadesController;
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
public class ObtenerTipoUnidadesControllerTest {
    @Mock
    IObtenerTipoUnidadesInput miObtenerTipoUnidadesInput;

    @Test
    public void obtenerTipoUnidades_TipoUnidadesExisten_Devuelve200(){
        List<TipoUnidad> tipoUnidades = new ArrayList<>();
        tipoUnidades.add(TipoUnidad.instancia(1,"Cliente"));
        when(miObtenerTipoUnidadesInput.obtenerTipoUnidades()).thenReturn(tipoUnidades);

        ObtenerTipoUnidadesController obtenerTipoUnidadesController = new ObtenerTipoUnidadesController(miObtenerTipoUnidadesInput);
        ResponseEntity<?> responseEntity = obtenerTipoUnidadesController.obtenerTipoUnidades();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        if(resultado != null) {
            Assertions.assertEquals(resultado.size(), 1);
        }
    }
}
