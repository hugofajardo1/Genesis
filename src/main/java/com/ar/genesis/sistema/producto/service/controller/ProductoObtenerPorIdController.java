package com.ar.genesis.sistema.producto.service.controller;

import com.ar.genesis.sistema.producto.core.domain.Producto;
import com.ar.genesis.sistema.producto.core.exception.ProductoNoExisteException;
import com.ar.genesis.sistema.producto.core.input.IProductoObtenerPorIdInput;
import com.ar.genesis.sistema.producto.service.dto.ProductoDTO;
import com.ar.genesis.sistema.proveedor.service.dto.ProveedorDTO;
import com.ar.genesis.sistema.rubro.service.dto.RubroDTO;
import com.ar.genesis.sistema.subrubro.service.dto.SubRubroDTO;
import com.ar.genesis.sistema.tipounidad.service.dto.TipoUnidadDTO;
import com.ar.genesis.sistema.ubicacion.service.dto.UbicacionDTO;
import org.modelmapper.ModelMapper;
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
                ModelMapper modelMapper = new ModelMapper();
                unProductoDTO = modelMapper.map(unProducto, ProductoDTO.class);
            }
            return ResponseEntity.status(HttpStatus.OK).body(unProductoDTO);
        } catch (ProductoNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}