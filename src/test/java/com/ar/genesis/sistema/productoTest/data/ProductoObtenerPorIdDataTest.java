package com.ar.genesis.sistema.productoTest.data;

import com.ar.genesis.sistema.producto.persistence.implementation.ProductoObtenerPorIdRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ProductoObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ProductoObtenerDespues.sql")
})
public class ProductoObtenerPorIdDataTest {
    @Inject
    ProductoObtenerPorIdRepoImplementacion miProductoObtenerPorIdRepoImplementacion;

    @Test
    public void obtenerProductoPorId_DevuelveProducto() {
        Assertions.assertNotNull(miProductoObtenerPorIdRepoImplementacion.obtenerProducto(1));
    }

    @Test
    public void obtenerProductoPorId_DevuelveNull() {
        Assertions.assertNull(miProductoObtenerPorIdRepoImplementacion.obtenerProducto(3));
    }
}
