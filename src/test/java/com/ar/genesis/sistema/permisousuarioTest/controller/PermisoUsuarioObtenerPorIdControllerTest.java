package com.ar.genesis.sistema.permisousuarioTest.controller;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioNoExisteException;
import com.ar.genesis.sistema.permisousuario.core.input.IPermisoUsuarioObtenerPorIdInput;
import com.ar.genesis.sistema.permisousuario.service.controller.PermisoUsuarioObtenerPorIdController;
import com.ar.genesis.sistema.permisousuario.service.dto.PermisoUsuarioDTO;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class PermisoUsuarioObtenerPorIdControllerTest {
    @Mock
    IPermisoUsuarioObtenerPorIdInput miPermisoUsuarioObtenerPorIdInput;

    @Test
    public void obtenerPermisoUsuarioPorId_DevuelvePermisoUsuario() throws PermisoUsuarioNoExisteException {
        PermisoUsuario unPermisoUsuario = PermisoUsuario.instancia(1, Permiso.instancia(1,"Permiso 1"), Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1")));
        when(miPermisoUsuarioObtenerPorIdInput.obtenerPermisoUsuario(1)).thenReturn(unPermisoUsuario);

        PermisoUsuarioObtenerPorIdController permisousuarioObtenerPorIdController = new PermisoUsuarioObtenerPorIdController(miPermisoUsuarioObtenerPorIdInput);
        ResponseEntity<?> responseEntity = permisousuarioObtenerPorIdController.obtenerPermisoUsuario(1);
        PermisoUsuarioDTO resultado = (PermisoUsuarioDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerPermisoUsuarioPorId_DevuelveNull() throws PermisoUsuarioNoExisteException {
        when(miPermisoUsuarioObtenerPorIdInput.obtenerPermisoUsuario(1)).thenReturn(null);

        PermisoUsuarioObtenerPorIdController permisousuarioObtenerPorIdController = new PermisoUsuarioObtenerPorIdController(miPermisoUsuarioObtenerPorIdInput);
        ResponseEntity<?> responseEntity = permisousuarioObtenerPorIdController.obtenerPermisoUsuario(1);
        PermisoUsuarioDTO resultado = (PermisoUsuarioDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
