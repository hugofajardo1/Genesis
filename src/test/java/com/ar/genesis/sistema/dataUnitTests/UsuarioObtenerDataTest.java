package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Usuario;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.UsuarioObtenerRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:UsuarioObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:UsuarioObtenerDespues.sql")
})
public class UsuarioObtenerDataTest {
    @Inject
    UsuarioObtenerRepoImplementacion miUsuarioObtenerRepoImplementacion;

    @Test
    public void obtenerUsuarios_UsuariosExisten_DevuelveListado(){
        List<Usuario> usuarios = miUsuarioObtenerRepoImplementacion.obtenerUsuarios();
        assertEquals(2, usuarios.size());
    }
}
