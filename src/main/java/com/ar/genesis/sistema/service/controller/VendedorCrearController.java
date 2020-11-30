package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Vendedor;
import com.ar.genesis.sistema.core.exception.VendedorExisteException;
import com.ar.genesis.sistema.core.input.IVendedorCrearInput;
import com.ar.genesis.sistema.service.dto.VendedorDTO;
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
            boolean resultado = this.miVendedorCrearInput.crearVendedor(Vendedor.instancia(unVendedorDTO.getId(), unVendedorDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (VendedorExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
