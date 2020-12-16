package com.ar.genesis.sistema.usuario.controller;

import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.exception.UsuarioExisteException;
import com.ar.genesis.sistema.usuario.core.input.IUsuarioModificarInput;
import com.ar.genesis.sistema.usuario.service.controller.UsuarioModificarController;
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
public class UsuarioModificarControllerTest {
    @Mock
    IUsuarioModificarInput miUsuarioModificarInput;

    @Test
    public  void modificarUsuario_UsuarioNoExiste_Devuelve200() throws UsuarioExisteException {
        UsuarioDTO unUsuarioDTO = new UsuarioDTO(1, "Usuario 1", "usuario", "contrasenia", new SucursalDTO(1, "Sucursal 1"));
        when(miUsuarioModificarInput.modificarUsuario(any(Usuario.class))).thenReturn(true);

        UsuarioModificarController usuarioModificarController = new UsuarioModificarController(miUsuarioModificarInput);
        ResponseEntity<?> responseEntity = usuarioModificarController.modificarUsuario(unUsuarioDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarUsuario_UsuarioExiste_Devuelve412() throws UsuarioExisteException {
        UsuarioDTO unUsuarioDTO = new UsuarioDTO(1, "Usuario 1", "usuario", "contrasenia", new SucursalDTO(1, "Sucursal 1"));
        when(miUsuarioModificarInput.modificarUsuario(any(Usuario.class))).thenThrow(UsuarioExisteException.class);

        UsuarioModificarController usuarioModificarController = new UsuarioModificarController(miUsuarioModificarInput);
        ResponseEntity<?> responseEntity = usuarioModificarController.modificarUsuario(unUsuarioDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
