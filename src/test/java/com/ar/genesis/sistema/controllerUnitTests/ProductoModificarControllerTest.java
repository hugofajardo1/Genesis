package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Producto;
import com.ar.genesis.sistema.core.exception.ProductoExisteException;
import com.ar.genesis.sistema.core.input.IProductoModificarInput;
import com.ar.genesis.sistema.service.controller.ProductoModificarController;
import com.ar.genesis.sistema.service.dto.ProductoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductoModificarControllerTest {
    @Mock
    IProductoModificarInput miProductoModificarInput;

    @Test
    public  void modificarProducto_ProductoNoExiste_Devuelve200() throws ProductoExisteException {
        ProductoDTO unProductoDTO = new ProductoDTO(1, "Producto 1");
        when(miProductoModificarInput.modificarProducto(any(Producto.class))).thenReturn(true);

        ProductoModificarController productoModificarController = new ProductoModificarController(miProductoModificarInput);
        ResponseEntity<?> responseEntity = productoModificarController.modificarProducto(unProductoDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarProducto_ProductoExiste_Devuelve412() throws ProductoExisteException {
        ProductoDTO unProductoDTO = new ProductoDTO(1, "Producto 2");
        when(miProductoModificarInput.modificarProducto(any(Producto.class))).thenThrow(ProductoExisteException.class);

        ProductoModificarController productoModificarController = new ProductoModificarController(miProductoModificarInput);
        ResponseEntity<?> responseEntity = productoModificarController.modificarProducto(unProductoDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
