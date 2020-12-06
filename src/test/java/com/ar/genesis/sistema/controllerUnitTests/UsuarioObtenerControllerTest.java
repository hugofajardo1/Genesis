package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.input.IUsuarioObtenerInput;
import com.ar.genesis.sistema.service.controller.UsuarioObtenerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
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
        usuarios.add(Usuario.instancia(1,"Usuario 1"));
        when(miUsuarioObtenerInput.obtenerUsuarios()).thenReturn(usuarios);

        UsuarioObtenerController usuarioObtenerController = new UsuarioObtenerController(miUsuarioObtenerInput);
        ResponseEntity<?> responseEntity = usuarioObtenerController.obtenerUsuarioes();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        if(resultado != null) {
            Assertions.assertEquals(resultado.size(), 1);
        }
    }
}
