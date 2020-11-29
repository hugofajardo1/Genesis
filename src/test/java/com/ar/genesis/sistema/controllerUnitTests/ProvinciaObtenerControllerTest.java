package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.input.IObtenerProvinciasInput;
import com.ar.genesis.sistema.service.controller.ObtenerProvinciasController;
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
    IObtenerProvinciasInput miObtenerProvinciasInput;

    @Test
    public void obtenerProvincias_ProvinciasExisten_Devuelve200(){
        List<Provincia> provincias = new ArrayList<>();
        provincias.add(Provincia.instancia(1,"Provincia  1"));
        when(miObtenerProvinciasInput.obtenerProvincias()).thenReturn(provincias);

        ObtenerProvinciasController obtenerProvinciasController = new ObtenerProvinciasController(miObtenerProvinciasInput);
        ResponseEntity<?> responseEntity = obtenerProvinciasController.obtenerProvincias();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        if(resultado != null) {
            Assertions.assertEquals(resultado.size(), 1);
        }
    }
}
