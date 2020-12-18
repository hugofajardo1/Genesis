package com.ar.genesis.sistema.fichaTest.controller;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.ficha.core.input.IFichaObtenerInput;
import com.ar.genesis.sistema.ficha.service.controller.FichaObtenerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class FichaObtenerControllerTest {
    @Mock
    IFichaObtenerInput miObtenerFichasInput;

    @Test
    public void obtenerFichas_FichasExisten_Devuelve200(){
        List<Ficha> fichas = new ArrayList<>();
        fichas.add(Ficha.instancia(1,"Fajardo, Hugo", "Bs. As. 245", Localidad.instancia(1, "Chilecito"), Provincia.instancia(1, "La Rioja"), "3825416543", TipoIva.instancia(1, "Responsable Inscripto"), "20255071336", "B-00007-777", "contacto"));
        when(miObtenerFichasInput.obtenerFichas()).thenReturn(fichas);

        FichaObtenerController fichaObtenerController = new FichaObtenerController(miObtenerFichasInput);
        ResponseEntity<?> responseEntity = fichaObtenerController.obtenerFichas();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
}
