package com.ar.genesis.sistema.permisoTest.controller;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.input.IPermisoObtenerInput;
import com.ar.genesis.sistema.permiso.service.controller.PermisoObtenerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class PermisoObtenerControllerTest {
    @Mock
    IPermisoObtenerInput miPermisoObtenerInput;

    @Test
    public void obtenerPermisos_PermisosExisten_Devuelve200(){
        List<Permiso> permisos = new ArrayList<>();
        permisos.add(Permiso.instancia(1,"Permiso  1"));
        when(miPermisoObtenerInput.obtenerPermisos()).thenReturn(permisos);

        PermisoObtenerController permisoObtenerController = new PermisoObtenerController(miPermisoObtenerInput);
        ResponseEntity<?> responseEntity = permisoObtenerController.obtenerPermisos();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
}
