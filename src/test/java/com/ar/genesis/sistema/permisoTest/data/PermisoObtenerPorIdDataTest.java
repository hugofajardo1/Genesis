package com.ar.genesis.sistema.permisoTest.data;

import com.ar.genesis.sistema.permiso.persistence.implementation.PermisoObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:PermisoObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:PermisoObtenerDespues.sql")
})
public class PermisoObtenerPorIdDataTest {
    @Inject
    PermisoObtenerPorIdRepoImplementacion miPermisoObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerPermisoPorId_DevuelvePermiso() {
        Assertions.assertNotNull(miPermisoObtenerPorIdRepoImplementacion.obtenerPermiso(1));
    }

    @Test
    public void obtenerPermisoPorId_DevuelveNull() {
        Assertions.assertNull(miPermisoObtenerPorIdRepoImplementacion.obtenerPermiso(3));
    }
}
