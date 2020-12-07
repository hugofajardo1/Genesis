package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.core.exception.UsuarioNoExisteException;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.UsuarioObtenerPorNombreUsuarioYContraseniaRepoImplmentacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:UsuarioObtenerPorNombreUsuarioYContraseniaAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:UsuarioObtenerPorNombreUsuarioYContraseniaDespues.sql")
})
public class UsuarioObtenerPorNombreUsuarioYContraseniaDataTest {
    @Inject
    UsuarioObtenerPorNombreUsuarioYContraseniaRepoImplmentacion miUsuarioObtenerPorNombreUsuarioYContraseniaRepoImplmentacion;

    @Test
    public void obtenerUsuarioPorNombreUsuarioYContrasenia_DevuelveUsuario() {
        Assertions.assertNotNull(miUsuarioObtenerPorNombreUsuarioYContraseniaRepoImplmentacion.obtenerUsuario("nombreUsuario", "contrasenia"));
    }

    @Test
    public void obtenerUsuarioPorNombreUsuarioYContrasenia_DevuelveNull() {
        Assertions.assertNull(miUsuarioObtenerPorNombreUsuarioYContraseniaRepoImplmentacion.obtenerUsuario("nombreUsuarioooo", "contrasenia"));
    }
}
