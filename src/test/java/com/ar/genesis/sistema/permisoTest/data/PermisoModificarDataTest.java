package com.ar.genesis.sistema.permisoTest.data;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.persistence.implementation.PermisoRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:PermisoModificarAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:PermisoModificarDespues.sql")
})
public class PermisoModificarDataTest {
    @Inject
    PermisoRepoImplementacion miPermisoRepoImplementacion;

    @Test
    public void guardarPermiso_PermisoGuardado_devuelveTrue() {
        Permiso unPermiso = Permiso.instancia(1, "Permiso 1");
        boolean resultado = miPermisoRepoImplementacion.guardarPermiso(unPermiso);
        Assertions.assertTrue(resultado);
    }
}
