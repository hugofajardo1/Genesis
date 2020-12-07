package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.exception.UsuarioNoExisteException;
import com.ar.genesis.sistema.core.input.IUsuarioObtenerPorNombreUsuarioYContraseniaInput;
import com.ar.genesis.sistema.service.controller.UsuarioObtenerPorNombreUsuarioYContraseniaController;
import com.ar.genesis.sistema.service.dto.UsuarioDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UsuarioObtenerPorNombreUsuarioYContraseniaControllerTest {
    @Mock
    IUsuarioObtenerPorNombreUsuarioYContraseniaInput miUsuarioObtenerPorNombreUsuarioYContraseniaInput;

    @Test
    public void obtenerUsuarioPorNombreUsuarioYContrasenia_DevuelveUsuario() throws UsuarioNoExisteException {
        Usuario unUsuario = Usuario.instancia(1,"Usuario 1", "nombreusuario", "contrasenia");
        when(miUsuarioObtenerPorNombreUsuarioYContraseniaInput.obtenerUsuario("nombreusuario", "contrasenia")).thenReturn(unUsuario);

        UsuarioObtenerPorNombreUsuarioYContraseniaController usuarioObtenerPorNombreUsuarioYContraseniaController = new UsuarioObtenerPorNombreUsuarioYContraseniaController(miUsuarioObtenerPorNombreUsuarioYContraseniaInput);
        ResponseEntity<?> responseEntity = usuarioObtenerPorNombreUsuarioYContraseniaController.obtenerUsuario("nombreusuario", "contrasenia");
        UsuarioDTO resultado = (UsuarioDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerUsuarioPorNombreUsuarioYContrasenia_DevuelveNull() throws UsuarioNoExisteException {
        when(miUsuarioObtenerPorNombreUsuarioYContraseniaInput.obtenerUsuario("nombreusuario", "contrasenia")).thenReturn(null);

        UsuarioObtenerPorNombreUsuarioYContraseniaController usuarioObtenerPorNombreUsuarioYContraseniaController = new UsuarioObtenerPorNombreUsuarioYContraseniaController(miUsuarioObtenerPorNombreUsuarioYContraseniaInput);
        ResponseEntity<?> responseEntity = usuarioObtenerPorNombreUsuarioYContraseniaController.obtenerUsuario("nombreusuario", "contrasenia");
        UsuarioDTO resultado = (UsuarioDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
