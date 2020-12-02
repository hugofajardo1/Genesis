package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.Producto;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.ProductoRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ProductoModificarAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ProductoModificarDespues.sql")
})
public class ProductoModificarDataTest {
    @Inject
    ProductoRepoImplementacion miProductoRepoImplementacion;

    @Test
    public void guardarProducto_ProductoGuardado_devuelveTrue() {
        Producto unProducto = Producto.instancia(1, "Producto 1");
        boolean resultado = miProductoRepoImplementacion.guardarProducto(unProducto);
        Assertions.assertTrue(resultado);
    }
}
