package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.exception.UsuarioNoExisteException;
import com.ar.genesis.sistema.core.input.IUsuarioObtenerPorIdInput;
import com.ar.genesis.sistema.service.controller.UsuarioObtenerPorIdController;
import com.ar.genesis.sistema.service.dto.UsuarioDTO;
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
        Usuario unUsuario = Usuario.instancia(1,"Usuario 1", "nombreusuario", "contrasenia");
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
