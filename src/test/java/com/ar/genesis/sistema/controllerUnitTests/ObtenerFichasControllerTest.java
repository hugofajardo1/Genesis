package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.input.IObtenerFichaInput;
import com.ar.genesis.sistema.service.controller.ObtenerFichasController;
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
public class ObtenerFichasControllerTest {
    @Mock
    IObtenerFichaInput obtenerFichasInput;

    @Test
    public void obtenerFichas_FichasExisten_Devuelve200(){
        List<Ficha> fichas = new ArrayList<>();
        fichas.add(Ficha.instancia(1,"Fajardo, Hugo", "Bs. As. 245", "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336"));
        when(obtenerFichasInput.obtenerFichas()).thenReturn(fichas);

        ObtenerFichasController obtenerFichasController = new ObtenerFichasController(obtenerFichasInput);
        ResponseEntity<?> responseEntity = obtenerFichasController.obtenerFichas();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        if(resultado != null) {
            Assertions.assertEquals(resultado.size(), 1);
        }
    }
}
