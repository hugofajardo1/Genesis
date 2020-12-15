package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.persistence.repositoryImplementacion.SucursalObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:SucursalObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:SucursalObtenerDespues.sql")
})
public class SucursalObtenerPorIdDataTest {
    @Inject
    SucursalObtenerPorIdRepoImplementacion miSucursalObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerSucursalPorId_DevuelveSucursal() {
        Assertions.assertNotNull(miSucursalObtenerPorIdRepoImplementacion.obtenerSucursal(1));
    }

    @Test
    public void obtenerSucursalPorId_DevuelveNull() {
        Assertions.assertNull(miSucursalObtenerPorIdRepoImplementacion.obtenerSucursal(3));
    }
}
