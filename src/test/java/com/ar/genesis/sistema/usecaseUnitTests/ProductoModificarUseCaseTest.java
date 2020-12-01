package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Producto;
import com.ar.genesis.sistema.core.exception.ProductoExisteException;
import com.ar.genesis.sistema.core.repository.IProductoRepository;
import com.ar.genesis.sistema.core.usecase.ProductoModificarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class ProductoModificarUseCaseTest {
    @Mock
    IProductoRepository miProductoRepository;
    @Test
    void modificarProducto_ProductoActualizadoCorrectamente() throws ProductoExisteException {
        Producto unProducto = Producto.instancia(1, "Producto");
        when(miProductoRepository.existeProducto("Producto")).thenReturn(false);
        when(miProductoRepository.guardarProducto(unProducto)).thenReturn(true);
        ProductoModificarUseCase productoModificarUseCase = new ProductoModificarUseCase(miProductoRepository);
        boolean resultado = productoModificarUseCase.modificarProducto(unProducto);
        Assertions.assertTrue(resultado);
    }

    @Test
    void modificarProducto_HayConflictoProductoExiste_ProductoNoActualiza() {
        Producto unProducto = Producto.instancia(1, "Producto");
        when(miProductoRepository.existeProducto("Producto")).thenReturn(true);
        when(miProductoRepository.guardarProducto(unProducto)).thenReturn(false);
        ProductoModificarUseCase productoModificarUseCase = new ProductoModificarUseCase(miProductoRepository);
        Assertions.assertThrows(ProductoExisteException.class, () -> productoModificarUseCase.modificarProducto(unProducto));
    }
}
