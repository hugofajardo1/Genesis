package com.ar.genesis.sistema.usuarioTest.data;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import com.ar.genesis.sistema.usuario.persistence.implementation.UsuarioRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:UsuarioModificarAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:UsuarioModificarDespues.sql")
})
public class UsuarioModificarDataTest {
    @Inject
    UsuarioRepoImplementacion miUsuarioRepoImplementacion;

    @Test
    public void guardarUsuario_UsuarioGuardado_devuelveTrue() {
        Usuario unUsuario = Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1"));
        boolean resultado = miUsuarioRepoImplementacion.guardarUsuario(unUsuario);
        Assertions.assertTrue(resultado);
    }
}
