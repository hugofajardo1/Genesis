package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.input.IProvinciaObtenerInput;
import com.ar.genesis.sistema.service.controller.ProvinciaObtenerController;
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
public class ProvinciaObtenerControllerTest {
    @Mock
    IProvinciaObtenerInput miProvinciaObtenerInput;

    @Test
    public void obtenerProvincias_ProvinciasExisten_Devuelve200(){
        List<Provincia> provincias = new ArrayList<>();
        provincias.add(Provincia.instancia(1,"Provincia  1"));
        when(miProvinciaObtenerInput.obtenerProvincias()).thenReturn(provincias);

        ProvinciaObtenerController provinciaObtenerController = new ProvinciaObtenerController(miProvinciaObtenerInput);
        ResponseEntity<?> responseEntity = provinciaObtenerController.obtenerProvincias();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertEquals(resultado.size(), 1);
    }
}
