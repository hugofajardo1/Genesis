package com.ar.genesis.sistema.usuario.data;

import com.ar.genesis.sistema.usuario.persistence.implementation.UsuarioObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:UsuarioObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:UsuarioObtenerDespues.sql")
})
public class UsuarioObtenerPorIdDataTest {
    @Inject
    UsuarioObtenerPorIdRepoImplementacion miUsuarioObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerUsuarioPorId_DevuelveUsuario() {
        Assertions.assertNotNull(miUsuarioObtenerPorIdRepoImplementacion.obtenerUsuario(1));
    }

    @Test
    public void obtenerUsuarioPorId_DevuelveNull() {
        Assertions.assertNull(miUsuarioObtenerPorIdRepoImplementacion.obtenerUsuario(3));
    }
}
