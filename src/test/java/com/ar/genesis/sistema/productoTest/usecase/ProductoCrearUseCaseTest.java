package com.ar.genesis.sistema.productoTest.usecase;

import com.ar.genesis.sistema.producto.core.exception.ProductoExisteException;
import com.ar.genesis.sistema.producto.core.repository.IProductoRepository;
import com.ar.genesis.sistema.producto.core.usecase.ProductoCrearUseCase;
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
public class ProductoCrearUseCaseTest {
    @Mock
    IProductoRepository miProductoRepository;
    @Test
    void crearTipoProducto_ProductoNoExiste_GuardaCorrectamente() throws ProductoExisteException {
        Producto unProducto = Producto.instancia(1, "Teclado Genius USB", "A548743", "770077007700770", TipoUnidad.instancia(1, "Unidad"), 100, 21, 35, 0, Rubro.instancia(1,"Hardware"), SubRubro.instancia(1, "Perifericos"), Ubicacion.instancia(1, "Estante 1"), Proveedor.instancia(1, "Proveedor 1"));
        when(miProductoRepository.existeProducto("Teclado Genius USB")).thenReturn(false);
        when(miProductoRepository.guardarProducto(unProducto)).thenReturn(true);
        ProductoCrearUseCase productoCrearUseCase = new ProductoCrearUseCase(miProductoRepository);
        boolean resultado = productoCrearUseCase.crearProducto(unProducto);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoProducto_ProductoExiste_NoGuardaTipoProducto() {
        Producto unProducto = Producto.instancia(1, "Teclado Genius USB", "A548743", "770077007700770", TipoUnidad.instancia(1, "Unidad"), 100, 21, 35, 0, Rubro.instancia(1,"Hardware"), SubRubro.instancia(1, "Perifericos"), Ubicacion.instancia(1, "Estante 1"), Proveedor.instancia(1, "Proveedor 1"));
        when(miProductoRepository.existeProducto("Teclado Genius USB")).thenReturn(true);
        when(miProductoRepository.guardarProducto(unProducto)).thenReturn(false);
        ProductoCrearUseCase productoCrearUseCase = new ProductoCrearUseCase(miProductoRepository);
        Assertions.assertThrows(ProductoExisteException.class, () -> productoCrearUseCase.crearProducto(unProducto));
    }
}
