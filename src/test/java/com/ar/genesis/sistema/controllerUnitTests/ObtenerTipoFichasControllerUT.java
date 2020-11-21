package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Cliente;
import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.input.IObtenerTipoFichasInput;
import com.ar.genesis.sistema.service.controller.ObtenerTipoFichasController;
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
public class ObtenerTipoFichasControllerUT {
    @Mock
    IObtenerTipoFichasInput obtenerTipoFichasInput;

    @Test
    public void obtenerTipoFichas_TipoFichasExisten_Devuelve200(){
        List<TipoFicha> losTipoFichas = new ArrayList<>();
        losTipoFichas.add(TipoFicha.instancia(1,"Cliente"));
        when(obtenerTipoFichasInput.obtenerTipoFichas()).thenReturn(losTipoFichas);

        ObtenerTipoFichasController obtenerTipoFichasController = new ObtenerTipoFichasController(obtenerTipoFichasInput);
        ResponseEntity<?> responseEntity = obtenerTipoFichasController.obtenerTipoFichas();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        if(resultado != null) {
            Assertions.assertEquals(resultado.size(), 1);
        }
    }
}
