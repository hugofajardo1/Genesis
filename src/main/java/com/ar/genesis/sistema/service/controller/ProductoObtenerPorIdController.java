package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Producto;
import com.ar.genesis.sistema.core.exception.ProductoNoExisteException;
import com.ar.genesis.sistema.core.input.IProductoObtenerPorIdInput;
import com.ar.genesis.sistema.service.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProductoObtenerPorIdController {
    @Inject
    IProductoObtenerPorIdInput miProductoObtenerPorIdInput;

    public ProductoObtenerPorIdController(IProductoObtenerPorIdInput miProductoObtenerPorIdInput) { this.miProductoObtenerPorIdInput = miProductoObtenerPorIdInput; }

    @GetMapping(value = "/producto/id/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable Integer id){
        try{
            Producto unProducto = miProductoObtenerPorIdInput.obtenerProducto(id);
            ProductoDTO unProductoDTO=null;
            if (unProducto!=null){
                unProductoDTO = new ProductoDTO(unProducto.getId(), unProducto.getNombre(), unProducto.getCodigoUsuario(), new TipoUnidadDTO(unProducto.getTipoUnidad().getId(), unProducto.getTipoUnidad().getNombre()), unProducto.getCosto(), unProducto.getIva(), unProducto.getMargen(), unProducto.getFlete(), new RubroDTO(unProducto.getRubro().getId(), unProducto.getRubro().getNombre()), new SubRubroDTO(unProducto.getSubRubro().getId(), unProducto.getSubRubro().getNombre()), new UbicacionDTO(unProducto.getUbicacion().getId(), unProducto.getUbicacion().getNombre()), new ProveedorDTO(unProducto.getProveedor().getId(), unProducto.getProveedor().getNombre()));
            }
            return ResponseEntity.status(HttpStatus.OK).body(unProductoDTO);
        } catch (ProductoNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}