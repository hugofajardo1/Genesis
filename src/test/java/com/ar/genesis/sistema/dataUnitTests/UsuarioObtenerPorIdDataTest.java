package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.persistence.repositoryImplementacion.UsuarioObtenerPorIdRepoImplmentacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:UsuarioObtenerPorIdAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:UsuarioObtenerPorIdDespues.sql")
})
public class UsuarioObtenerPorIdDataTest {
    @Inject
    UsuarioObtenerPorIdRepoImplmentacion miUsuarioObtenerPorIdRepoImplmentacion;

    @Test
    public void obtenerUsuarioPorNombreUsuarioYContrasenia_DevuelveUsuario() {
        Assertions.assertNotNull(miUsuarioObtenerPorIdRepoImplmentacion.obtenerUsuario(1));
    }

    @Test
    public void obtenerUsuarioPorNombreUsuarioYContrasenia_DevuelveNull() {
        Assertions.assertNull(miUsuarioObtenerPorIdRepoImplmentacion.obtenerUsuario(2));
    }
}
