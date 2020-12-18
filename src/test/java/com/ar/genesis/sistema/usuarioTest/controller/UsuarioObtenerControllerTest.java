package com.ar.genesis.sistema.usuarioTest.controller;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.core.input.IUsuarioObtenerInput;
import com.ar.genesis.sistema.usuario.service.controller.UsuarioObtenerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UsuarioObtenerControllerTest {
    @Mock
    IUsuarioObtenerInput miUsuarioObtenerInput;

    @Test
    public void obtenerUsuarios_UsuariosExisten_Devuelve200(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(Usuario.instancia(1,"Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1")));
        when(miUsuarioObtenerInput.obtenerUsuarios()).thenReturn(usuarios);

        UsuarioObtenerController usuarioObtenerController = new UsuarioObtenerController(miUsuarioObtenerInput);
        ResponseEntity<?> responseEntity = usuarioObtenerController.obtenerUsuarios();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
}
