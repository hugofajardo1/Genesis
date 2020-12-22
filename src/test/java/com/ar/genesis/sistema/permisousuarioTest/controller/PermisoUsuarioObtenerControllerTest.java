package com.ar.genesis.sistema.permisousuarioTest.controller;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.core.input.IPermisoUsuarioObtenerInput;
import com.ar.genesis.sistema.permisousuario.service.controller.PermisoUsuarioObtenerController;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class PermisoUsuarioObtenerControllerTest {
    @Mock
    IPermisoUsuarioObtenerInput miPermisoUsuarioObtenerInput;

    @Test
    public void obtenerPermisoUsuarios_PermisoUsuariosExisten_Devuelve200(){
        List<PermisoUsuario> permisousuarios = new ArrayList<>();
        permisousuarios.add(PermisoUsuario.instancia(1, Permiso.instancia(1,"Permiso 1"), Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1"))));
        when(miPermisoUsuarioObtenerInput.obtenerPermisoUsuarios()).thenReturn(permisousuarios);

        PermisoUsuarioObtenerController permisousuarioObtenerController = new PermisoUsuarioObtenerController(miPermisoUsuarioObtenerInput);
        ResponseEntity<?> responseEntity = permisousuarioObtenerController.obtenerPermisoUsuarios();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
}
