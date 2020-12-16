package com.ar.genesis.sistema.vendedor.data;

import com.ar.genesis.sistema.vendedor.persistence.implementation.VendedorObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:VendedorObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:VendedorObtenerDespues.sql")
})
public class VendedorObtenerPorIdDataTest {
    @Inject
    VendedorObtenerPorIdRepoImplementacion miVendedorObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerVendedorPorId_DevuelveVendedor() {
        Assertions.assertNotNull(miVendedorObtenerPorIdRepoImplementacion.obtenerVendedor(1));
    }

    @Test
    public void obtenerVendedorPorId_DevuelveNull() {
        Assertions.assertNull(miVendedorObtenerPorIdRepoImplementacion.obtenerVendedor(3));
    }
}
