package com.ar.genesis.sistema.productoTest.usecase;

import com.ar.genesis.sistema.producto.core.repository.IProductoObtenerRepository;
import com.ar.genesis.sistema.producto.core.usecase.ProductoObtenerUseCase;
import com.ar.genesis.sistema.producto.core.domain.Producto;
import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
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
        Producto producto1 = Producto.instancia(1, "Producto 1", "Teclado Genius USB", "770077007700770", TipoUnidad.instancia(1, "Unidad"), 100, 21, 35, 0, Rubro.instancia(1, "Hardware"), SubRubro.instancia(1, "Perifericos"), Ubicacion.instancia(1, "Estante 1"), Proveedor.instancia(1, "Proveedor 1"));
        Producto producto2 = Producto.instancia(2, "Producto 2", "Teclado Genius USB KB100", "770077007700771", TipoUnidad.instancia(1, "Unidad"), 100, 21, 35, 0, Rubro.instancia(1, "Hardware"), SubRubro.instancia(1, "Perifericos"), Ubicacion.instancia(1, "Estante 1"), Proveedor.instancia(1, "Proveedor 1"));
        productos.add(producto1);
        productos.add(producto2);
        return productos;
    }
}
