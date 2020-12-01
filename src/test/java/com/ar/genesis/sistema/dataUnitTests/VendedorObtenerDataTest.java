package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Vendedor;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.VendedorObtenerRepoImplmentacion;
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
    VendedorObtenerRepoImplmentacion miVendedorObtenerRepoImplmentacion;

    @Test
    public void obtenerVendedores_VendedoresExisten_DevuelveListado(){
        List<Vendedor> vendedores = miVendedorObtenerRepoImplmentacion.obtenerVendedores();
        assertEquals(2, vendedores.size());
    }
}
