package com.ar.genesis.sistema.productoTest.controller;

import com.ar.genesis.sistema.producto.core.input.IProductoObtenerInput;
import com.ar.genesis.sistema.producto.core.domain.Producto;
import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.producto.service.controller.ProductoObtenerController;
import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductoObtenerControllerTest {
    @Mock
    IProductoObtenerInput miProductoObtenerInput;

    @Test
    public void obtenerProductos_ProductosExisten_Devuelve200(){
        List<Producto> productos = new ArrayList<>();
        productos.add(Producto.instancia(1, "Producto  1", "Teclado Genius USB", "770077007700770", TipoUnidad.instancia(1, "Unidad"), 100, 21, 35, 0, Rubro.instancia(1, "Hardware"), SubRubro.instancia(1, "Perifericos"), Ubicacion.instancia(1, "Estante 1"), Proveedor.instancia(1, "Proveedor 1")));
        when(miProductoObtenerInput.obtenerProductos()).thenReturn(productos);

        ProductoObtenerController ProductoObtenerController = new ProductoObtenerController(miProductoObtenerInput);
        ResponseEntity<?> responseEntity = ProductoObtenerController.obtenerProductos();
        List<?> resultado = (List<?>) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
}
