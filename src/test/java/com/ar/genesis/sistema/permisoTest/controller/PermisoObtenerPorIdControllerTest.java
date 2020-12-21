package com.ar.genesis.sistema.permisoTest.controller;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.core.exception.PermisoNoExisteException;
import com.ar.genesis.sistema.permiso.core.input.IPermisoObtenerPorIdInput;
import com.ar.genesis.sistema.permiso.service.controller.PermisoObtenerPorIdController;
import com.ar.genesis.sistema.permiso.service.dto.PermisoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class PermisoObtenerPorIdControllerTest {
    @Mock
    IPermisoObtenerPorIdInput miPermisoObtenerPorIdInput;

    @Test
    public void obtenerPermisoPorId_DevuelvePermiso() throws PermisoNoExisteException {
        Permiso unPermiso = Permiso.instancia(1,"Permiso 1");
        when(miPermisoObtenerPorIdInput.obtenerPermiso(1)).thenReturn(unPermiso);

        PermisoObtenerPorIdController permisoObtenerPorIdController = new PermisoObtenerPorIdController(miPermisoObtenerPorIdInput);
        ResponseEntity<?> responseEntity = permisoObtenerPorIdController.obtenerPermiso(1);
        PermisoDTO resultado = (PermisoDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerPermisoPorId_DevuelveNull() throws PermisoNoExisteException {
        when(miPermisoObtenerPorIdInput.obtenerPermiso(1)).thenReturn(null);

        PermisoObtenerPorIdController permisoObtenerPorIdController = new PermisoObtenerPorIdController(miPermisoObtenerPorIdInput);
        ResponseEntity<?> responseEntity = permisoObtenerPorIdController.obtenerPermiso(1);
        PermisoDTO resultado = (PermisoDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
