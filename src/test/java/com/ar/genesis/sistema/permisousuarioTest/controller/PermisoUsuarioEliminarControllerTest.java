package com.ar.genesis.sistema.permisousuarioTest.controller;

import com.ar.genesis.sistema.permiso.service.dto.PermisoDTO;
import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioExisteException;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioNoExisteException;
import com.ar.genesis.sistema.permisousuario.core.input.IPermisoUsuarioEliminarInput;
import com.ar.genesis.sistema.permisousuario.service.controller.PermisoUsuarioEliminarController;
import com.ar.genesis.sistema.permisousuario.service.dto.PermisoUsuarioDTO;
import com.ar.genesis.sistema.sucursal.service.dto.SucursalDTO;
import com.ar.genesis.sistema.usuario.service.dto.UsuarioDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PermisoUsuarioEliminarControllerTest {
    @Mock
    IPermisoUsuarioEliminarInput miPermisoUsuarioEliminarInput;

    @Test
    public  void eliminarPermisoUsuario_PermisoUsuarioNoExiste_Devuelve200() throws PermisoUsuarioNoExisteException {
        PermisoDTO unPermisoDTO = new PermisoDTO(1, "Permiso");
        UsuarioDTO unUsuarioDTO = new UsuarioDTO(1, "Usuario 1", "usuario", "contrasenia", new SucursalDTO(1, "Sucursal 1"));
        PermisoUsuarioDTO unPermisoUsuarioDTO = new PermisoUsuarioDTO(1, unPermisoDTO, unUsuarioDTO);
        when(miPermisoUsuarioEliminarInput.eliminarPermisoUsuario(any(PermisoUsuario.class))).thenReturn(true);

        PermisoUsuarioEliminarController permisousuarioEliminarController = new PermisoUsuarioEliminarController(miPermisoUsuarioEliminarInput);
        ResponseEntity<?> responseEntity = permisousuarioEliminarController.eliminarPermisoUsuario(unPermisoUsuarioDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void eliminarPermisoUsuario_PermisoUsuarioExiste_Devuelve412() throws PermisoUsuarioNoExisteException {
        PermisoDTO unPermisoDTO = new PermisoDTO(1, "Permiso");
        UsuarioDTO unUsuarioDTO = new UsuarioDTO(1, "Usuario 1", "usuario", "contrasenia", new SucursalDTO(1, "Sucursal 1"));
        PermisoUsuarioDTO unPermisoUsuarioDTO = new PermisoUsuarioDTO(1, unPermisoDTO, unUsuarioDTO);
        when(miPermisoUsuarioEliminarInput.eliminarPermisoUsuario(any(PermisoUsuario.class))).thenThrow(PermisoUsuarioNoExisteException.class);

        PermisoUsuarioEliminarController permisousuarioEliminarController = new PermisoUsuarioEliminarController(miPermisoUsuarioEliminarInput);
        ResponseEntity<?> responseEntity = permisousuarioEliminarController.eliminarPermisoUsuario(unPermisoUsuarioDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
