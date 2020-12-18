package com.ar.genesis.sistema.tipofichaTest.data;

import com.ar.genesis.sistema.tipoficha.persistence.implementation.TipoFichaObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:TipoFichaObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:TipoFichaObtenerDespues.sql")
})
public class TipoFichaObtenerPorIdDataTest {
    @Inject
    TipoFichaObtenerPorIdRepoImplementacion miTipoFichaObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerTipoFichaPorId_DevuelveTipoFicha() {
        Assertions.assertNotNull(miTipoFichaObtenerPorIdRepoImplementacion.obtenerTipoFicha(1));
    }

    @Test
    public void obtenerTipoFichaPorId_DevuelveNull() {
        Assertions.assertNull(miTipoFichaObtenerPorIdRepoImplementacion.obtenerTipoFicha(3));
    }
}
