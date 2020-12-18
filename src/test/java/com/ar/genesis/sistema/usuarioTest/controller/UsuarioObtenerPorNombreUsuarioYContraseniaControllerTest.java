package com.ar.genesis.sistema.usuarioTest.controller;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.exception.UsuarioNoExisteException;
import com.ar.genesis.sistema.usuario.core.input.IUsuarioObtenerPorNombreUsuarioYContraseniaInput;
import com.ar.genesis.sistema.usuario.service.controller.UsuarioObtenerPorNombreUsuarioYContraseniaController;
import com.ar.genesis.sistema.usuario.service.dto.UsuarioDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UsuarioObtenerPorNombreUsuarioYContraseniaControllerTest {
    @Mock
    IUsuarioObtenerPorNombreUsuarioYContraseniaInput miUsuarioObtenerPorNombreUsuarioYContraseniaInput;

    @Test
    public void obtenerUsuarioPorNombreUsuarioYContrasenia_DevuelveUsuario() throws UsuarioNoExisteException {
        Usuario unUsuario = Usuario.instancia(1,"Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1"));
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
