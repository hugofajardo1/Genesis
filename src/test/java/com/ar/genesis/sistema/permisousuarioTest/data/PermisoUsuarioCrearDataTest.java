package com.ar.genesis.sistema.permisousuarioTest.data;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.permisousuario.core.domain.PermisoUsuario;
import com.ar.genesis.sistema.permisousuario.persistence.implementation.PermisoUsuarioRepoImplementacion;
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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:PermisoUsuarioCrearAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:PermisoUsuarioCrearDespues.sql")
})
public class PermisoUsuarioCrearDataTest {
    @Inject
    PermisoUsuarioRepoImplementacion miPermisoUsuarioRepoImplementacion;

    @Test
    public void guardarPermisoUsuario_PermisoUsuarioGuardado_devuelveTrue() {
        PermisoUsuario unPermisoUsuario = PermisoUsuario.instancia(null, Permiso.instancia(1,"Permiso 1"), Usuario.instancia(1, "Usuario 1", "nombreusuario", "contrasenia", Sucursal.instancia(1, "Sucursal 1")));
        boolean resultado = miPermisoUsuarioRepoImplementacion.guardarPermisoUsuario(unPermisoUsuario);
        Assertions.assertTrue(resultado);
    }

}
