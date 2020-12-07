package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.exception.UsuarioExisteException;
import com.ar.genesis.sistema.core.input.IUsuarioCrearInput;
import com.ar.genesis.sistema.service.controller.UsuarioCrearController;
import com.ar.genesis.sistema.service.dto.UsuarioDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UsuarioCrearControllerTest {
    @Mock
    IUsuarioCrearInput miUsuarioCrearInput;

    @Test
    public  void crearUsuario_UsuarioNoExiste_Devuelve200() throws UsuarioExisteException {
        UsuarioDTO unUsuarioDTO = new UsuarioDTO(1, "Usuario 1", "usuario", "contrasenia");
        when(miUsuarioCrearInput.crearUsuario(any(Usuario.class))).thenReturn(true);

        UsuarioCrearController usuarioCrearController = new UsuarioCrearController(miUsuarioCrearInput);
        ResponseEntity<?> responseEntity = usuarioCrearController.crearUsuario(unUsuarioDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearUsuario_UsuarioExiste_Devuelve412() throws UsuarioExisteException {
        UsuarioDTO unUsuarioDTO = new UsuarioDTO(1, "Usuario 1", "usuario", "contrasenia");
        when(miUsuarioCrearInput.crearUsuario(any(Usuario.class))).thenThrow(UsuarioExisteException.class);

        UsuarioCrearController usuarioCrearController = new UsuarioCrearController(miUsuarioCrearInput);
        ResponseEntity<?> responseEntity = usuarioCrearController.crearUsuario(unUsuarioDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
