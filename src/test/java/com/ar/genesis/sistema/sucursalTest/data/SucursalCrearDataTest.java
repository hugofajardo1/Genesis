package com.ar.genesis.sistema.sucursalTest.data;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.sucursal.persistence.implementation.SucursalRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:SucursalCrearAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:SucursalCrearDespues.sql")
})
public class SucursalCrearDataTest {
    @Inject
    SucursalRepoImplementacion miSucursalRepoImplementacion;

    @Test
    public void guardarSucursal_SucursalGuardado_devuelveTrue() {
        Sucursal unaSucursal = Sucursal.instancia(null, "Sucursal 1");
        boolean resultado = miSucursalRepoImplementacion.guardarSucursal(unaSucursal);
        Assertions.assertTrue(resultado);
    }

}
