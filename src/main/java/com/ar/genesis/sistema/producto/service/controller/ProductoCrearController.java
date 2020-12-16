package com.ar.genesis.sistema.producto.service.controller;

import com.ar.genesis.sistema.producto.core.exception.ProductoExisteException;
import com.ar.genesis.sistema.producto.core.input.IProductoCrearInput;
import com.ar.genesis.sistema.producto.core.domain.Producto;
import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.producto.service.dto.ProductoDTO;
import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProductoCrearController {
    @Inject
    IProductoCrearInput miProductoCrearInput;

    public ProductoCrearController(IProductoCrearInput miProductoCrearInput) {
        this.miProductoCrearInput = miProductoCrearInput;
    }

    @PostMapping(value = "/producto")
    public ResponseEntity<?> crearProducto(@RequestBody ProductoDTO unProductoDTO){
        try{
            boolean resultado = this.miProductoCrearInput.crearProducto(Producto.instancia(unProductoDTO.getId(), unProductoDTO.getNombre(), unProductoDTO.getCodigoUsuario(), unProductoDTO.getCodigoBarra(), TipoUnidad.instancia(unProductoDTO.getTipoUnidad().getId(), unProductoDTO.getTipoUnidad().getNombre()), unProductoDTO.getCosto(), unProductoDTO.getIva(), unProductoDTO.getMargen(), unProductoDTO.getFlete(), Rubro.instancia(unProductoDTO.getRubro().getId(), unProductoDTO.getRubro().getNombre()), SubRubro.instancia(unProductoDTO.getSubRubro().getId(), unProductoDTO.getSubRubro().getNombre()), Ubicacion.instancia(unProductoDTO.getUbicacion().getId(), unProductoDTO.getUbicacion().getNombre()), Proveedor.instancia(unProductoDTO.getProveedor().getId(), unProductoDTO.getProveedor().getNombre())));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ProductoExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}