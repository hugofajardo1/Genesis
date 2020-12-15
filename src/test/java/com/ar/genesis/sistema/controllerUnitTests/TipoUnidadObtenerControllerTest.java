package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.input.ITipoUnidadObtenerInput;
import com.ar.genesis.sistema.service.controller.TipoUnidadObtenerController;
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
public class TipoUnidadObtenerControllerTest {
    @Mock
    ITipoUnidadObtenerInput miTipoUnidadObtenerInput;

    @Test
    public void obtenerTipoUnidades_TipoUnidadesExisten_Devuelve200(){
        List<TipoUnidad> tipoUnidades = new ArrayList<>();
        tipoUnidades.add(TipoUnidad.instancia(1,"Cliente"));
        when(miTipoUnidadObtenerInput.obtenerTipoUnidades()).thenReturn(tipoUnidades);

        TipoUnidadObtenerController tipoUnidadObtenerController = new TipoUnidadObtenerController(miTipoUnidadObtenerInput);
        ResponseEntity<?> responseEntity = tipoUnidadObtenerController.obtenerTipoUnidades();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
}
