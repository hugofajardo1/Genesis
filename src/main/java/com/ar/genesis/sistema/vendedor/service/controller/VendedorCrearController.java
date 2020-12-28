package com.ar.genesis.sistema.vendedor.service.controller;

import com.ar.genesis.sistema.vendedor.core.domain.Vendedor;
import com.ar.genesis.sistema.vendedor.core.exception.VendedorExisteException;
import com.ar.genesis.sistema.vendedor.core.input.IVendedorCrearInput;
import com.ar.genesis.sistema.vendedor.service.dto.VendedorDTO;
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
public class VendedorCrearController {
    @Inject
    IVendedorCrearInput miVendedorCrearInput;

    public VendedorCrearController(IVendedorCrearInput miVendedorCrearInput) { this.miVendedorCrearInput = miVendedorCrearInput; }

    @PostMapping(value = "/vendedor")
    public ResponseEntity<?> crearVendedor(@RequestBody VendedorDTO unVendedorDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miVendedorCrearInput.crearVendedor(modelMapper.map(unVendedorDTO, Vendedor.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (VendedorExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
