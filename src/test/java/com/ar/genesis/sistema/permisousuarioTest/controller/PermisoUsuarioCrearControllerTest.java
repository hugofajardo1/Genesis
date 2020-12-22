package com.ar.genesis.sistema.permisousuarioTest.controller;

import com.ar.genesis.sistema.permiso.service.dto.PermisoDTO;
import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.exception.PermisoUsuarioExisteException;
import com.ar.genesis.sistema.permisousuario.core.input.IPermisoUsuarioCrearInput;
import com.ar.genesis.sistema.permisousuario.service.controller.PermisoUsuarioCrearController;
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
public class PermisoUsuarioCrearControllerTest {
    @Mock
    IPermisoUsuarioCrearInput miPermisoUsuarioCrearInput;

    @Test
    public  void crearPermisoUsuario_PermisoUsuarioNoExiste_Devuelve200() throws PermisoUsuarioExisteException {
        PermisoDTO unPermisoDTO = new PermisoDTO(1, "Permiso");
        UsuarioDTO unUsuarioDTO = new UsuarioDTO(1, "Usuario 1", "usuario", "contrasenia", new SucursalDTO(1, "Sucursal 1"));
        PermisoUsuarioDTO unPermisoUsuarioDTO = new PermisoUsuarioDTO(1, unPermisoDTO, unUsuarioDTO);
        when(miPermisoUsuarioCrearInput.crearPermisoUsuario(any(PermisoUsuario.class))).thenReturn(true);

        PermisoUsuarioCrearController permisousuarioCrearController = new PermisoUsuarioCrearController(miPermisoUsuarioCrearInput);
        ResponseEntity<?> responseEntity = permisousuarioCrearController.crearPermisoUsuario(unPermisoUsuarioDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearPermisoUsuario_PermisoUsuarioExiste_Devuelve412() throws PermisoUsuarioExisteException {
        PermisoDTO unPermisoDTO = new PermisoDTO(1, "Permiso");
        UsuarioDTO unUsuarioDTO = new UsuarioDTO(1, "Usuario 1", "usuario", "contrasenia", new SucursalDTO(1, "Sucursal 1"));
        PermisoUsuarioDTO unPermisoUsuarioDTO = new PermisoUsuarioDTO(1, unPermisoDTO, unUsuarioDTO);
        when(miPermisoUsuarioCrearInput.crearPermisoUsuario(any(PermisoUsuario.class))).thenThrow(PermisoUsuarioExisteException.class);

        PermisoUsuarioCrearController permisousuarioCrearController = new PermisoUsuarioCrearController(miPermisoUsuarioCrearInput);
        ResponseEntity<?> responseEntity = permisousuarioCrearController.crearPermisoUsuario(unPermisoUsuarioDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
