package com.ar.genesis.sistema.usecaseUnitTests;

import com.ar.genesis.sistema.core.domain.Producto;
import com.ar.genesis.sistema.core.exception.ProductoExisteException;
import com.ar.genesis.sistema.core.repository.IProductoRepository;
import com.ar.genesis.sistema.core.usecase.ProductoCrearUseCase;
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
        Producto unProducto = Producto.instancia(1, "Producto");
        when(miProductoRepository.existeProducto("Producto")).thenReturn(false);
        when(miProductoRepository.guardarProducto(unProducto)).thenReturn(true);
        ProductoCrearUseCase productoCrearUseCase = new ProductoCrearUseCase(miProductoRepository);
        boolean resultado = productoCrearUseCase.crearProducto(unProducto);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearTipoProducto_ProductoExiste_NoGuardaTipoProducto() {
        Producto unProducto = Producto.instancia(1, "Producto");
        when(miProductoRepository.existeProducto("Producto")).thenReturn(true);
        when(miProductoRepository.guardarProducto(unProducto)).thenReturn(false);
        ProductoCrearUseCase productoCrearUseCase = new ProductoCrearUseCase(miProductoRepository);
        Assertions.assertThrows(ProductoExisteException.class, () -> productoCrearUseCase.crearProducto(unProducto));
    }
}
