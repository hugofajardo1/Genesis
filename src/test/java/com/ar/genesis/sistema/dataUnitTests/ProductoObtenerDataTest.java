package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Producto;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.ProductoObtenerRepoImplmentacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ProductoObtenerAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ProductoObtenerDespues.sql")
})
public class ProductoObtenerDataTest {
    @Inject
    ProductoObtenerRepoImplmentacion miProductoObtenerRepoImplmentacion;

    @Test
    public void obtenerProductos_ProductosExisten_DevuelveListado(){
        List<Producto> Productos = miProductoObtenerRepoImplmentacion.obtenerProductos();
        assertEquals(2, Productos.size());
    }
}
