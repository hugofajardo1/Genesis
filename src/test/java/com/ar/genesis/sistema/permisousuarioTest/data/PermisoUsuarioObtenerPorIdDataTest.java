package com.ar.genesis.sistema.permisousuarioTest.data;

import com.ar.genesis.sistema.permisousuario.persistence.implementation.PermisoUsuarioObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:PermisoUsuarioObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:PermisoUsuarioObtenerDespues.sql")
})
public class PermisoUsuarioObtenerPorIdDataTest {
    @Inject
    PermisoUsuarioObtenerPorIdRepoImplementacion miPermisoUsuarioObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerPermisoUsuarioPorId_DevuelvePermisoUsuario() {
        Assertions.assertNotNull(miPermisoUsuarioObtenerPorIdRepoImplementacion.obtenerPermisoUsuario(1));
    }

    @Test
    public void obtenerPermisoUsuarioPorId_DevuelveNull() {
        Assertions.assertNull(miPermisoUsuarioObtenerPorIdRepoImplementacion.obtenerPermisoUsuario(3));
    }
}
