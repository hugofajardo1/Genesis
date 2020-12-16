package com.ar.genesis.sistema.producto.controller;

import com.ar.genesis.sistema.producto.core.exception.ProductoNoExisteException;
import com.ar.genesis.sistema.producto.core.input.IProductoObtenerPorIdInput;
import com.ar.genesis.sistema.producto.core.domain.Producto;
import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.producto.service.controller.ProductoObtenerPorIdController;
import com.ar.genesis.sistema.producto.service.dto.ProductoDTO;
import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductoObtenerPorIdControllerTest {
    @Mock
    IProductoObtenerPorIdInput miProductoObtenerPorIdInput;

    @Test
    public void obtenerProductoPorId_DevuelveProducto() throws ProductoNoExisteException {
        Producto unProducto = Producto.instancia(1, "Teclado Genius USB", "A548743", "770077007700770", TipoUnidad.instancia(1, "Unidad"), 100, 21, 35, 0, Rubro.instancia(1,"Hardware"), SubRubro.instancia(1, "Perifericos"), Ubicacion.instancia(1, "Estante 1"), Proveedor.instancia(1, "Proveedor 1"));
        when(miProductoObtenerPorIdInput.obtenerProducto(1)).thenReturn(unProducto);

        ProductoObtenerPorIdController productoObtenerPorIdController = new ProductoObtenerPorIdController(miProductoObtenerPorIdInput);
        ResponseEntity<?> responseEntity = productoObtenerPorIdController.obtenerProducto(1);
        ProductoDTO resultado = (ProductoDTO) responseEntity.getBody();
        Assertions.assertNotNull(resultado);
    }
    @Test
    public void obtenerProductoPorId_DevuelveNull() throws ProductoNoExisteException {
        when(miProductoObtenerPorIdInput.obtenerProducto(1)).thenReturn(null);

        ProductoObtenerPorIdController productoObtenerPorIdController = new ProductoObtenerPorIdController(miProductoObtenerPorIdInput);
        ResponseEntity<?> responseEntity = productoObtenerPorIdController.obtenerProducto(1);
        ProductoDTO resultado = (ProductoDTO) responseEntity.getBody();
        Assertions.assertNull(resultado);
    }
}
