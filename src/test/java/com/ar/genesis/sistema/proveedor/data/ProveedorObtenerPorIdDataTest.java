package com.ar.genesis.sistema.proveedor.data;

import com.ar.genesis.sistema.proveedor.persistence.implementation.ProveedorObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ProveedorObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ProveedorObtenerDespues.sql")
})
public class ProveedorObtenerPorIdDataTest {
    @Inject
    ProveedorObtenerPorIdRepoImplementacion miProveedorObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerProveedorPorId_DevuelveProveedor() {
        Assertions.assertNotNull(miProveedorObtenerPorIdRepoImplementacion.obtenerProveedor(1));
    }

    @Test
    public void obtenerProveedorPorId_DevuelveNull() {
        Assertions.assertNull(miProveedorObtenerPorIdRepoImplementacion.obtenerProveedor(3));
    }
}
