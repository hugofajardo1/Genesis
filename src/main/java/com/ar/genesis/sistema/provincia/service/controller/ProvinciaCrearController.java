package com.ar.genesis.sistema.provincia.service.controller;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.provincia.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.provincia.core.input.IProvinciaCrearInput;
import com.ar.genesis.sistema.provincia.service.dto.ProvinciaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProvinciaCrearController {
    @Inject
    IProvinciaCrearInput miProvinciaCrearInput;

    public ProvinciaCrearController(IProvinciaCrearInput miProvinciaCrearInput) { this.miProvinciaCrearInput = miProvinciaCrearInput; }

    @PostMapping(value = "/provincia")
    public ResponseEntity<?> crearProvincia(@RequestBody ProvinciaDTO unaProvinciaDTO){
        try{
            boolean resultado = this.miProvinciaCrearInput.crearProvincia(Provincia.instancia(unaProvinciaDTO.getId(), unaProvinciaDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ProvinciaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}