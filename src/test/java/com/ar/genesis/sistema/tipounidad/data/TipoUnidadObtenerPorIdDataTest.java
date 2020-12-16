package com.ar.genesis.sistema.tipounidad.data;

import com.ar.genesis.sistema.tipounidad.persistence.implementation.TipoUnidadObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:TipoUnidadObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:TipoUnidadObtenerDespues.sql")
})
public class TipoUnidadObtenerPorIdDataTest {
    @Inject
    TipoUnidadObtenerPorIdRepoImplementacion miTipoUnidadObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerTipoUnidadPorId_DevuelveTipoUnidad() {
        Assertions.assertNotNull(miTipoUnidadObtenerPorIdRepoImplementacion.obtenerTipoUnidad(1));
    }

    @Test
    public void obtenerTipoUnidadPorId_DevuelveNull() {
        Assertions.assertNull(miTipoUnidadObtenerPorIdRepoImplementacion.obtenerTipoUnidad(3));
    }
}
