package com.ar.genesis.sistema.permisoTest.data;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permiso.persistence.implementation.PermisoObtenerRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:PermisoObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:PermisoObtenerDespues.sql")
})
public class PermisoObtenerDataTest {
    @Inject
    PermisoObtenerRepoImplementacion miPermisoObtenerRepoImplementacion;

    @Test
    public void obtenerPermisos_PermisosExisten_DevuelveListado(){
        List<Permiso> permisos = miPermisoObtenerRepoImplementacion.obtenerPermisos();
        assertEquals(2, permisos.size());
    }
}
