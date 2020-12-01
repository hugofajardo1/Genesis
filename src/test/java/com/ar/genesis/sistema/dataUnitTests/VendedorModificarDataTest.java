package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Vendedor;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.VendedorRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:VendedorModificarAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:VendedorModificarDespues.sql")
})
public class VendedorModificarDataTest {
    @Inject
    VendedorRepoImplementacion miVendedorRepoImplementacion;

    @Test
    public void guardarVendedor_VendedorGuardado_devuelveTrue() {
        Vendedor unVendedor = Vendedor.instancia(1, "Cliente");
        boolean resultado = miVendedorRepoImplementacion.guardarVendedor(unVendedor);
        Assertions.assertTrue(resultado);
    }
}
