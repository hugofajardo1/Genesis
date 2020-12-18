package com.ar.genesis.sistema.productoTest.controller;

import com.ar.genesis.sistema.producto.core.domain.Producto;
import com.ar.genesis.sistema.producto.core.exception.ProductoExisteException;
import com.ar.genesis.sistema.producto.core.input.IProductoModificarInput;
import com.ar.genesis.sistema.producto.service.controller.ProductoModificarController;
import com.ar.genesis.sistema.producto.service.dto.ProductoDTO;
import com.ar.genesis.sistema.proveedor.service.dto.ProveedorDTO;
import com.ar.genesis.sistema.rubro.service.dto.RubroDTO;
import com.ar.genesis.sistema.subrubro.service.dto.SubRubroDTO;
import com.ar.genesis.sistema.tipounidad.service.dto.TipoUnidadDTO;
import com.ar.genesis.sistema.ubicacion.service.dto.UbicacionDTO;
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
        ProductoDTO unProductoDTO = new ProductoDTO(1, "Producto 1", "A32345", "770077007700770", new TipoUnidadDTO(1, "Unidad"), 100.0, 21.0, 35.0, 0.0, new RubroDTO(1, "Hardware"), new SubRubroDTO(1, "Perifericos"), new UbicacionDTO(1, "Estante 1"), new ProveedorDTO(1, "Proveedor 1"));
        when(miProductoModificarInput.modificarProducto(any(Producto.class))).thenReturn(true);

        ProductoModificarController productoModificarController = new ProductoModificarController(miProductoModificarInput);
        ResponseEntity<?> responseEntity = productoModificarController.modificarProducto(unProductoDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertTrue(resultado);
    }

    @Test
    public  void modificarProducto_ProductoExiste_Devuelve412() throws ProductoExisteException {
        ProductoDTO unProductoDTO = new ProductoDTO(1, "Producto 1", "A32345", "770077007700770", new TipoUnidadDTO(1, "Unidad"), 100.0, 21.0, 35.0, 0.0, new RubroDTO(1, "Hardware"), new SubRubroDTO(1, "Perifericos"), new UbicacionDTO(1, "Estante 1"), new ProveedorDTO(1, "Proveedor 1"));
        when(miProductoModificarInput.modificarProducto(any(Producto.class))).thenThrow(ProductoExisteException.class);

        ProductoModificarController productoModificarController = new ProductoModificarController(miProductoModificarInput);
        ResponseEntity<?> responseEntity = productoModificarController.modificarProducto(unProductoDTO);
        String resultado = (String) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }
}
