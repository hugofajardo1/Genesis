package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.UsuarioRepoImplementacion;
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
        Usuario unUsuario = Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia");
        boolean resultado = miUsuarioRepoImplementacion.guardarUsuario(unUsuario);
        Assertions.assertTrue(resultado);
    }
}
