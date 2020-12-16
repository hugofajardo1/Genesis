package com.ar.genesis.sistema.subrubro.data;

import com.ar.genesis.sistema.subrubro.persistence.implementation.SubRubroObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:SubRubroObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:SubRubroObtenerDespues.sql")
})
public class SubRubroObtenerPorIdDataTest {
    @Inject
    SubRubroObtenerPorIdRepoImplementacion miSubRubroObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerSubRubroPorId_DevuelveSubRubro() {
        Assertions.assertNotNull(miSubRubroObtenerPorIdRepoImplementacion.obtenerSubRubro(1));
    }

    @Test
    public void obtenerSubRubroPorId_DevuelveNull() {
        Assertions.assertNull(miSubRubroObtenerPorIdRepoImplementacion.obtenerSubRubro(3));
    }
}
