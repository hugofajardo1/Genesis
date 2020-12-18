package com.ar.genesis.sistema.vendedorTest.data;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.persistence.implementation.VendedorRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:VendedorCrearAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:VendedorCrearDespues.sql")
})
public class VendedorCrearDataTest {

    @Inject
    VendedorRepoImplementacion miVendedorRepoImplementacion;

    @Test
    public void guardarVendedor_VendedorGuardado_devuelveTrue() {
        Vendedor unVendedor = Vendedor.instancia(null, "Vendedor 1");
        boolean resultado = miVendedorRepoImplementacion.guardarVendedor(unVendedor);
        Assertions.assertTrue(resultado);
    }

}
