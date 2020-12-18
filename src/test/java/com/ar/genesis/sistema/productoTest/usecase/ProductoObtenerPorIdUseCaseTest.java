package com.ar.genesis.sistema.productoTest.usecase;

import com.ar.genesis.sistema.producto.core.exception.ProductoNoExisteException;
import com.ar.genesis.sistema.producto.core.repository.IProductoObtenerPorIdRepository;
import com.ar.genesis.sistema.producto.core.usecase.ProductoObtenerPorIdUseCase;
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

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ProductoObtenerPorIdUseCaseTest {
    @Mock
    IProductoObtenerPorIdRepository miProductoObtenerPorIdRepository;

    @Test
    public void obtenerProductoPorId_devuelveProducto() throws ProductoNoExisteException {
        Producto unProducto = Producto.instancia(1, "A548743", "Teclado Genius USB", "770077007700770", TipoUnidad.instancia(1, "Unidad"), 100, 21, 35, 0, Rubro.instancia(1,"Hardware"), SubRubro.instancia(1, "Perifericos"), Ubicacion.instancia(1, "Estante 1"), Proveedor.instancia(1, "Proveedor 1"));

        when(miProductoObtenerPorIdRepository.obtenerProducto(1)).thenReturn(unProducto);

        ProductoObtenerPorIdUseCase productoObtenerPorIdUseCase = new ProductoObtenerPorIdUseCase(miProductoObtenerPorIdRepository);
        Producto resultado = productoObtenerPorIdUseCase.obtenerProducto(1);
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerProductoPorId_devuelveProductoNoExiste() {

        when(miProductoObtenerPorIdRepository.obtenerProducto(1)).thenReturn(null);

        ProductoObtenerPorIdUseCase productoObtenerPorIdUseCase = new ProductoObtenerPorIdUseCase(miProductoObtenerPorIdRepository);
        Assertions.assertThrows(ProductoNoExisteException.class, () -> productoObtenerPorIdUseCase.obtenerProducto(1));
    }
}