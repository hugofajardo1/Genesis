package com.ar.genesis.sistema.producto.data;

import com.ar.genesis.sistema.producto.persistence.implementation.ProductoRepoImplementacion;
import com.ar.genesis.sistema.producto.core.domain.Producto;
import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
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
        Producto unProducto = Producto.instancia(null, "Producto", "Teclado Genius USB", "770077007700770", TipoUnidad.instancia(1, "Unidad"), 100, 21, 35, 0, Rubro.instancia(1, "Hardware"), SubRubro.instancia(1, "Perifericos"), Ubicacion.instancia(1, "Estante 1"), Proveedor.instancia(1, "Proveedor 1"));
        boolean resultado = miProductoRepoImplementacion.guardarProducto(unProducto);
        Assertions.assertTrue(resultado);
    }

}
