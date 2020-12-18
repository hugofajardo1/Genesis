package com.ar.genesis.sistema.vendedorTest.data;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.persistence.implementation.VendedorObtenerRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:VendedorObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:VendedorObtenerDespues.sql")
})
public class VendedorObtenerDataTest {
    @Inject
    VendedorObtenerRepoImplementacion miVendedorObtenerRepoImplementacion;

    @Test
    public void obtenerVendedores_VendedoresExisten_DevuelveListado(){
        List<Vendedor> vendedores = miVendedorObtenerRepoImplementacion.obtenerVendedores();
        assertEquals(2, vendedores.size());
    }
}
