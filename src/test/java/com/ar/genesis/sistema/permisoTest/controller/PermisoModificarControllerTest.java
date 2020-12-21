package com.ar.genesis.sistema.permisoTest.controller;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.exception.PermisoExisteException;
import com.ar.genesis.sistema.permiso.core.input.IPermisoModificarInput;
import com.ar.genesis.sistema.permiso.service.controller.PermisoModificarController;
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
public class PermisoModificarControllerTest {
    @Mock
    IPermisoModificarInput miPermisoModificarInput;

    @Test
    public  void modificarPermiso_PermisoNoExiste_Devuelve200() throws PermisoExisteException {
        PermisoDTO unPermisoDTO = new PermisoDTO(1, "Permiso 1");
        when(miPermisoModificarInput.modificarPermiso(any(Permiso.class))).thenReturn(true);

        PermisoModificarController permisoModificarController = new PermisoModificarController(miPermisoModificarInput);
        ResponseEntity<?> responseEntity = permisoModificarController.modificarPermiso(unPermisoDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarPermiso_PermisoExiste_Devuelve412() throws PermisoExisteException {
        PermisoDTO unPermisoDTO = new PermisoDTO(1, "Permiso 2");
        when(miPermisoModificarInput.modificarPermiso(any(Permiso.class))).thenThrow(PermisoExisteException.class);

        PermisoModificarController permisoModificarController = new PermisoModificarController(miPermisoModificarInput);
        ResponseEntity<?> responseEntity = permisoModificarController.modificarPermiso(unPermisoDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
