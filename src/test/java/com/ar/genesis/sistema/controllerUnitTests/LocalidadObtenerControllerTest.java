package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.input.ILocalidadObtenerInput;
import com.ar.genesis.sistema.service.controller.LocalidadObtenerController;
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
public class LocalidadObtenerControllerTest {
    @Mock
    ILocalidadObtenerInput miLocalidadObtenerInput;

    @Test
    public void obtenerLocalidades_LocalidadesExisten_Devuelve200(){
        List<Localidad> localidades = new ArrayList<>();
        localidades.add(Localidad.instancia(1,"Localidad 1"));
        when(miLocalidadObtenerInput.obtenerLocalidades()).thenReturn(localidades);

        LocalidadObtenerController localidadObtenerController = new LocalidadObtenerController(miLocalidadObtenerInput);
        ResponseEntity<?> responseEntity = localidadObtenerController.obtenerLocalidades();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertEquals(resultado.size(), 1);
    }
}
