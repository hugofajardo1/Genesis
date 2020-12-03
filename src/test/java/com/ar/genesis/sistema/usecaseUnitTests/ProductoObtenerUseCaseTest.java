package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.*;
import com.ar.genesis.sistema.core.repository.IProductoObtenerRepository;
import com.ar.genesis.sistema.core.usecase.ProductoObtenerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ProductoObtenerUseCaseTest {
    @Mock
    IProductoObtenerRepository miProductoObtenerRepository;
    @Spy
    List<Producto> productos = factoryListaProductos();

    @Test
    public void obtenerProductos_devuelveLista(){
        when(miProductoObtenerRepository.obtenerProductos()).thenReturn(productos);
        ProductoObtenerUseCase productoObtenerUseCase = new ProductoObtenerUseCase(miProductoObtenerRepository);
        List<Producto> resultado = productoObtenerUseCase.obtenerProductos();
        Assertions.assertEquals(2,resultado.size());
    }

    public List<Producto> factoryListaProductos() {
        List<Producto> productos = new ArrayList<>();
        Producto producto1 = Producto.instancia(1, "Teclado Genius USB", "Producto 1", TipoUnidad.instancia(1, "Unidad"), 100, 21, 35, 0, Rubro.instancia(1, "Hardware"), SubRubro.instancia(1, "Perifericos"), Ubicacion.instancia(1, "Estante 1"), Proveedor.instancia(1, "Proveedor 1"));
        Producto producto2 = Producto.instancia(2, "Teclado Genius USB KB100", "Producto 2", TipoUnidad.instancia(1, "Unidad"), 100, 21, 35, 0, Rubro.instancia(1, "Hardware"), SubRubro.instancia(1, "Perifericos"), Ubicacion.instancia(1, "Estante 1"), Proveedor.instancia(1, "Proveedor 1"));
        productos.add(producto1);
        productos.add(producto2);
        return productos;
    }
}
