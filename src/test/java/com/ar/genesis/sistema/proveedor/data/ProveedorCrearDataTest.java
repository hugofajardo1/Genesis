package com.ar.genesis.sistema.proveedor.data;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.persistence.implementation.ProveedorRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ProveedorCrearAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ProveedorCrearDespues.sql")
})
public class ProveedorCrearDataTest {

    @Inject
    ProveedorRepoImplementacion miProveedorRepoImplementacion;

    @Test
    public void guardarProveedor_ProveedorGuardado_devuelveTrue() {
        Proveedor unProveedor = Proveedor.instancia(null, "Proveedor 1");
        boolean resultado = miProveedorRepoImplementacion.guardarProveedor(unProveedor);
        Assertions.assertTrue(resultado);
    }

}
