package com.ar.genesis.sistema.permisousuarioTest.data;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.persistence.implementation.PermisoUsuarioEliminarRepoImplementacion;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:PermisoUsuarioModificarAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:PermisoUsuarioModificarDespues.sql")
})
public class PermisoUsuarioEliminarDataTest {
    @Inject
    PermisoUsuarioEliminarRepoImplementacion miPermisoUsuarioEliminarRepoImplementacion;

    @Test
    public void eliminarPermisoUsuario_PermisoUsuarioEliminado_devuelveTrue() {
        PermisoUsuario unPermisoUsuario = PermisoUsuario.instancia(1, Permiso.instancia(1,"Permiso 1"), Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1")));
        boolean resultado = miPermisoUsuarioEliminarRepoImplementacion.eliminarPermisoUsuario(unPermisoUsuario);
        Assertions.assertTrue(resultado);
    }
}
