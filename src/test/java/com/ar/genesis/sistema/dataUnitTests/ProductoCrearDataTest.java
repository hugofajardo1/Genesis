package com.ar.genesis.sistema.dataUnitTests;

import com.ar.genesis.sistema.core.domain.*;
import com.ar.genesis.sistema.persistence.repositoryImplementacion.ProductoRepoImplementacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import javax.inject.Inject;

@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ProductoCrearAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ProductoCrearDespues.sql")
})
public class ProductoCrearDataTest {
    @Inject
    ProductoRepoImplementacion miProductoRepoImplementacion;

    @Test
    public void guardarProducto_ProductoGuardado_devuelveTrue() {
        Producto unProducto = Producto.instancia(null, "Teclado Genius USB", "Producto", TipoUnidad.instancia(1, "Unidad"), 100, 21, 35, 0, Rubro.instancia(1, "Hardware"), SubRubro.instancia(1, "Perifericos"), Ubicacion.instancia(1, "Estante 1"));
        boolean resultado = miProductoRepoImplementacion.guardarProducto(unProducto);
        Assertions.assertTrue(resultado);
    }

}
