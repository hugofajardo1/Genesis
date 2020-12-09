package com.ar.genesis.sistema.controllerUnitTests;

import com.ar.genesis.sistema.core.domain.Producto;
import com.ar.genesis.sistema.core.exception.ProductoExisteException;
import com.ar.genesis.sistema.core.input.IProductoCrearInput;
import com.ar.genesis.sistema.service.controller.ProductoCrearController;
import com.ar.genesis.sistema.service.dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductoCrearControllerTest {
    @Mock
    IProductoCrearInput miProductoCrearInput;

    @Test
    public  void crearProducto_ProductoNoExiste_Devuelve200() throws ProductoExisteException {
        ProductoDTO unProductoDTO = new ProductoDTO(1, "Producto", "C42343", "770077007700770", new TipoUnidadDTO(1, "Unidad"), 100.0, 21.0, 35.0, 0.0, new RubroDTO(1, "Hardware"), new SubRubroDTO(1, "Perifericos"), new UbicacionDTO(1, "Estante 1"), new ProveedorDTO(1, "Proveedor 1"));
        when(miProductoCrearInput.crearProducto(any(Producto.class))).thenReturn(true);

        ProductoCrearController productoCrearController = new ProductoCrearController(miProductoCrearInput);
        ResponseEntity<?> responseEntity = productoCrearController.crearProducto(unProductoDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void crearProducto_ProductoExiste_Devuelve412() throws ProductoExisteException {
        ProductoDTO unProductoDTO = new ProductoDTO(1, "Producto", "C42343", "770077007700770", new TipoUnidadDTO(1, "Unidad"), 100.0, 21.0, 35.0, 0.0, new RubroDTO(1, "Hardware"), new SubRubroDTO(1, "Perifericos"), new UbicacionDTO(1, "Estante 1"), new ProveedorDTO(1, "Proveedor 1"));
        when(miProductoCrearInput.crearProducto(any(Producto.class))).thenThrow(ProductoExisteException.class);

        ProductoCrearController productoCrearController = new ProductoCrearController(miProductoCrearInput);
        ResponseEntity<?> responseEntity = productoCrearController.crearProducto(unProductoDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
