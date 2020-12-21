package com.ar.genesis.sistema.permisoTest.controller;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.exception.PermisoExisteException;
import com.ar.genesis.sistema.permiso.core.input.IPermisoCrearInput;
import com.ar.genesis.sistema.permiso.service.controller.PermisoCrearController;
import com.ar.genesis.sistema.permiso.service.dto.PermisoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PermisoCrearControllerTest {
    @Mock
    IPermisoCrearInput miPermisoCrearInput;

    @Test
    public  void crearPermiso_PermisoNoExiste_Devuelve200() throws PermisoExisteException {
        PermisoDTO unPermisoDTO = new PermisoDTO(1, "Permiso");
        when(miPermisoCrearInput.crearPermiso(any(Permiso.class))).thenReturn(true);

        PermisoCrearController permisoCrearController = new PermisoCrearController(miPermisoCrearInput);
        ResponseEntity<?> responseEntity = permisoCrearController.crearPermiso(unPermisoDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearPermiso_PermisoExiste_Devuelve412() throws PermisoExisteException {
        PermisoDTO unPermisoDTO = new PermisoDTO(1, "Permiso");
        when(miPermisoCrearInput.crearPermiso(any(Permiso.class))).thenThrow(PermisoExisteException.class);

        PermisoCrearController permisoCrearController = new PermisoCrearController(miPermisoCrearInput);
        ResponseEntity<?> responseEntity = permisoCrearController.crearPermiso(unPermisoDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
