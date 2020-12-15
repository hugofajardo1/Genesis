package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.input.IUbicacionObtenerInput;
import com.ar.genesis.sistema.service.controller.UbicacionObtenerController;
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
public class UbicacionObtenerControllerTest {
    @Mock
    IUbicacionObtenerInput miUbicacionObtenerInput;

    @Test
    public void obtenerUbicaciones_UbicacionesExisten_Devuelve200(){
        List<Ubicacion> ubicaciones = new ArrayList<>();
        ubicaciones.add(Ubicacion.instancia(1,"Ubicacion 1"));
        when(miUbicacionObtenerInput.obtenerUbicaciones()).thenReturn(ubicaciones);

        UbicacionObtenerController ubicacionObtenerController = new UbicacionObtenerController(miUbicacionObtenerInput);
        ResponseEntity<?> responseEntity = ubicacionObtenerController.obtenerUbicaciones();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
}
