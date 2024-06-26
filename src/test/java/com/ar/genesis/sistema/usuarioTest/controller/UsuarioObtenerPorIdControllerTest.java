package com.ar.genesis.sistema.usuarioTest.controller;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.exception.UsuarioNoExisteException;
import com.ar.genesis.sistema.usuario.core.input.IUsuarioObtenerPorIdInput;
import com.ar.genesis.sistema.usuario.service.controller.UsuarioObtenerPorIdController;
import com.ar.genesis.sistema.usuario.service.dto.UsuarioDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UsuarioObtenerPorIdControllerTest {
    @Mock
    IUsuarioObtenerPorIdInput miUsuarioObtenerPorIdInput;

    @Test
    public void obtenerUsuarioPorId_DevuelveUsuario() throws UsuarioNoExisteException {
        Usuario unUsuario = Usuario.instancia(1,"Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1"));
        when(miUsuarioObtenerPorIdInput.obtenerUsuario(1)).thenReturn(unUsuario);

        UsuarioObtenerPorIdController usuarioObtenerPorIdController = new UsuarioObtenerPorIdController(miUsuarioObtenerPorIdInput);
        ResponseEntity<?> responseEntity = usuarioObtenerPorIdController.obtenerUsuario(1);
        UsuarioDTO resultado = (UsuarioDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerUsuarioPorId_DevuelveNull() throws UsuarioNoExisteException {
        when(miUsuarioObtenerPorIdInput.obtenerUsuario(1)).thenReturn(null);

        UsuarioObtenerPorIdController usuarioObtenerPorIdController = new UsuarioObtenerPorIdController(miUsuarioObtenerPorIdInput);
        ResponseEntity<?> responseEntity = usuarioObtenerPorIdController.obtenerUsuario(1);
        UsuarioDTO resultado = (UsuarioDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
