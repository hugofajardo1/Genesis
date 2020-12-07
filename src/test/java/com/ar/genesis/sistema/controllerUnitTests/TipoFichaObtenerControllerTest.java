package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.input.ITipoFichaObtenerInput;
import com.ar.genesis.sistema.service.controller.TipoFichaObtenerController;
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
public class TipoFichaObtenerControllerTest {
    @Mock
    ITipoFichaObtenerInput miTipoFichaObtenerInput;

    @Test
    public void obtenerTipoFichas_TipoFichasExisten_Devuelve200(){
        List<TipoFicha> tipoFichas = new ArrayList<>();
        tipoFichas.add(TipoFicha.instancia(1,"Cliente"));
        when(miTipoFichaObtenerInput.obtenerTipoFichas()).thenReturn(tipoFichas);

        TipoFichaObtenerController tipoFichaObtenerController = new TipoFichaObtenerController(miTipoFichaObtenerInput);
        ResponseEntity<?> responseEntity = tipoFichaObtenerController.obtenerTipoFichas();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertEquals(resultado.size(), 1);
    }
}
