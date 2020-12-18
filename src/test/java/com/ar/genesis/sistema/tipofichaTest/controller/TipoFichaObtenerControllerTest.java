package com.ar.genesis.sistema.tipofichaTest.controller;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;
import com.ar.genesis.sistema.tipoficha.core.input.ITipoFichaObtenerInput;
import com.ar.genesis.sistema.tipoficha.service.controller.TipoFichaObtenerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
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
        Assertions.assertNotNull(resultado);
    }
}
