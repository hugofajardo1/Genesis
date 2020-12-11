package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Sucursal;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.SucursalObtenerRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:SucursalObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:SucursalObtenerDespues.sql")
})
public class SucursalObtenerDataTest {
    @Inject
    SucursalObtenerRepoImplementacion miSucursalObtenerRepoImplementacion;

    @Test
    public void obtenerSucursales_SucursalesExisten_DevuelveListado(){
        List<Sucursal> Sucursales = miSucursalObtenerRepoImplementacion.obtenerSucursales();
        assertEquals(2, Sucursales.size());
    }
}
