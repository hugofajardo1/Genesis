package com.ar.genesis.sistema.proveedorTest.data;

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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ProveedorModificarAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ProveedorModificarDespues.sql")
})
public class ProveedorModificarDataTest {
    @Inject
    ProveedorRepoImplementacion miProveedorRepoImplementacion;

    @Test
    public void guardarProveedor_ProveedorGuardado_devuelveTrue() {
        Proveedor unProveedor = Proveedor.instancia(1, "Proveedor");
        boolean resultado = miProveedorRepoImplementacion.guardarProveedor(unProveedor);
        Assertions.assertTrue(resultado);
    }
}
