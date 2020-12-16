package com.ar.genesis.sistema.producto.service.controller;

import com.ar.genesis.sistema.producto.core.input.IProductoObtenerInput;
import com.ar.genesis.sistema.producto.service.dto.ProductoDTO;
import com.ar.genesis.sistema.proveedor.service.dto.ProveedorDTO;
import com.ar.genesis.sistema.rubro.service.dto.RubroDTO;
import com.ar.genesis.sistema.subrubro.service.dto.SubRubroDTO;
import com.ar.genesis.sistema.tipounidad.service.dto.TipoUnidadDTO;
import com.ar.genesis.sistema.ubicacion.service.dto.UbicacionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProductoObtenerController {
    @Inject
    IProductoObtenerInput miProductoObtenerInput;

    public ProductoObtenerController(IProductoObtenerInput miProductoObtenerInput) {
        this.miProductoObtenerInput = miProductoObtenerInput;
    }
    @GetMapping(value = "/producto")
    public ResponseEntity<?> obtenerProductos(){
        try{
            List<ProductoDTO> productosDTO = new ArrayList<>();
            miProductoObtenerInput.obtenerProductos().forEach(unProducto -> productosDTO.add(new ProductoDTO(unProducto.getId(), unProducto.getNombre(), unProducto.getCodigoUsuario(), unProducto.getCodigoBarra(), new TipoUnidadDTO(unProducto.getTipoUnidad().getId(), unProducto.getTipoUnidad().getNombre()), unProducto.getCosto(), unProducto.getIva(), unProducto.getMargen(), unProducto.getFlete(), new RubroDTO(unProducto.getRubro().getId(), unProducto.getRubro().getNombre()), new SubRubroDTO(unProducto.getSubRubro().getId(), unProducto.getSubRubro().getNombre()), new UbicacionDTO(unProducto.getUbicacion().getId(), unProducto.getUbicacion().getNombre()), new ProveedorDTO(unProducto.getProveedor().getId(), unProducto.getProveedor().getNombre()))));
            if (productosDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(productosDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
