package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.*;
import com.ar.genesis.sistema.core.exception.ProductoExisteException;
import com.ar.genesis.sistema.core.input.IProductoModificarInput;
import com.ar.genesis.sistema.service.dto.ProductoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProductoModificarController {
    @Inject
    IProductoModificarInput miProductoModificarInput;

    public ProductoModificarController(IProductoModificarInput miProductoModificarInput) { this.miProductoModificarInput = miProductoModificarInput; }

    @PutMapping(value = "/producto")
    public ResponseEntity<?> modificarProducto(@RequestBody ProductoDTO unProductoDTO){
        try{
            boolean resultado = this.miProductoModificarInput.modificarProducto(Producto.instancia(unProductoDTO.getId(), "Teclado Genius USB", unProductoDTO.getNombre(), TipoUnidad.instancia(1, "Unidad"), 100, 21, 35, 0, Rubro.instancia(1, "Hardware"), SubRubro.instancia(1, "Perifericos"), Ubicacion.instancia(1, "Estante 1"), Proveedor.instancia(1, "Proveedor 1")));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ProductoExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
