package com.ar.genesis.sistema.proveedor.service.controller;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.exception.ProveedorExisteException;
import com.ar.genesis.sistema.proveedor.core.input.IProveedorCrearInput;
import com.ar.genesis.sistema.proveedor.service.dto.ProveedorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProveedorCrearController {
    @Inject
    IProveedorCrearInput miProveedorCrearInput;

    public ProveedorCrearController(IProveedorCrearInput miProveedorCrearInput) { this.miProveedorCrearInput = miProveedorCrearInput; }

    @PostMapping(value = "/proveedor")
    public ResponseEntity<?> crearProveedor(@RequestBody ProveedorDTO unProveedorDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miProveedorCrearInput.crearProveedor(modelMapper.map(unProveedorDTO, Proveedor.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ProveedorExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
