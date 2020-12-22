package com.ar.genesis.sistema.permisousuarioTest.data;

import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.persistence.implementation.PermisoUsuarioObtenerRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:PermisoUsuarioObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:PermisoUsuarioObtenerDespues.sql")
})
public class PermisoUsuarioObtenerDataTest {
    @Inject
    PermisoUsuarioObtenerRepoImplementacion miPermisoUsuarioObtenerRepoImplementacion;

    @Test
    public void obtenerPermisoUsuarios_PermisoUsuariosExisten_DevuelveListado(){
        List<PermisoUsuario> permisousuarios = miPermisoUsuarioObtenerRepoImplementacion.obtenerPermisoUsuarios();
        assertEquals(2, permisousuarios.size());
    }
}
