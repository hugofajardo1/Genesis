package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Producto;
import com.ar.genesis.sistema.core.exception.ProductoExisteException;
import com.ar.genesis.sistema.core.input.IProductoCrearInput;
import com.ar.genesis.sistema.service.dto.ProductoDTO;
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
            boolean resultado = this.miProductoCrearInput.crearProducto(Producto.instancia(unProductoDTO.getId(), unProductoDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ProductoExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}