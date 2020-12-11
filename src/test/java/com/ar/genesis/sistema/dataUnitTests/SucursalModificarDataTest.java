package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Sucursal;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.SucursalRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:SucursalModificarAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:SucursalModificarDespues.sql")
})
public class SucursalModificarDataTest {
    @Inject
    SucursalRepoImplementacion miSucursalRepoImplementacion;

    @Test
    public void guardarSucursal_SucursalGuardado_devuelveTrue() {
        Sucursal unaSucursal = Sucursal.instancia(1, "Sucursal 1");
        boolean resultado = miSucursalRepoImplementacion.guardarSucursal(unaSucursal);
        Assertions.assertTrue(resultado);
    }
}
