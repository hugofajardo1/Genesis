package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.input.IObtenerUbicacionesInput;
import com.ar.genesis.sistema.service.controller.ObtenerUbicacionesController;
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
public class ObtenerUbicacionesControllerTest {
    @Mock
    IObtenerUbicacionesInput obtenerUbicacionesInput;

    @Test
    public void obtenerUbicaciones_UbicacionesExisten_Devuelve200(){
        List<Ubicacion> ubicaciones = new ArrayList<>();
        ubicaciones.add(Ubicacion.instancia(1,"Ubicacion 1"));
        when(obtenerUbicacionesInput.obtenerUbicaciones()).thenReturn(ubicaciones);

        ObtenerUbicacionesController obtenerUbicacionesController = new ObtenerUbicacionesController(obtenerUbicacionesInput);
        ResponseEntity<?> responseEntity = obtenerUbicacionesController.obtenerUbicaciones();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        if(resultado != null) {
            Assertions.assertEquals(resultado.size(), 1);
        }
    }
}
