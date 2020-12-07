package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.persistence.repositoryImplementacion.UsuarioObtenerPorNombreUsuarioYContraseniaRepoImplementacion;
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
public class UsuarioObtenerPorNombreUsuarioYContraseniaDataTest {
    @Inject
    UsuarioObtenerPorNombreUsuarioYContraseniaRepoImplementacion miUsuarioObtenerPorNombreUsuarioYContraseniaRepoImplementacion;

    @Test
    public void obtenerUsuarioPorNombreUsuarioYContrasenia_DevuelveUsuario() {
        Assertions.assertNotNull(miUsuarioObtenerPorNombreUsuarioYContraseniaRepoImplementacion.obtenerUsuario("nombreUsuario", "contrasenia"));
    }

    @Test
    public void obtenerUsuarioPorNombreUsuarioYContrasenia_DevuelveNull() {
        Assertions.assertNull(miUsuarioObtenerPorNombreUsuarioYContraseniaRepoImplementacion.obtenerUsuario("nombreUsuarioooo", "contrasenia"));
    }
}
