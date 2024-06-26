package com.ar.genesis.sistema.proveedor.service.controller;

import com.ar.genesis.sistema.proveedor.core.domain.Proveedor;
import com.ar.genesis.sistema.proveedor.core.exception.ProveedorExisteException;
import com.ar.genesis.sistema.proveedor.core.input.IProveedorModificarInput;
import com.ar.genesis.sistema.proveedor.service.dto.ProveedorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProveedorModificarController {
    @Inject
    IProveedorModificarInput miProveedorModificarInput;

    public ProveedorModificarController(IProveedorModificarInput miProveedorModificarInput) { this.miProveedorModificarInput = miProveedorModificarInput; }

    @PutMapping(value = "/proveedor")
    public ResponseEntity<?> modificarProveedor(@RequestBody ProveedorDTO unProveedorDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miProveedorModificarInput.modificarProveedor(modelMapper.map(unProveedorDTO, Proveedor.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ProveedorExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
