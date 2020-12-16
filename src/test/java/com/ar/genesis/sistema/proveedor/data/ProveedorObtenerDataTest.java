package com.ar.genesis.sistema.proveedor.data;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.persistence.implementation.ProveedorObtenerRepoImplementacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ProveedorObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ProveedorObtenerDespues.sql")
})
public class ProveedorObtenerDataTest {
    @Inject
    ProveedorObtenerRepoImplementacion miProveedorObtenerRepoImplementacion;

    @Test
    public void obtenerProveedores_ProveedoresExisten_DevuelveListado(){
        List<Proveedor> proveedores = miProveedorObtenerRepoImplementacion.obtenerProveedores();
        assertEquals(2, proveedores.size());
    }
}
