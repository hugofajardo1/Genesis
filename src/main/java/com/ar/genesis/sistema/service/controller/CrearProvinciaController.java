package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.core.input.ICrearProvinciaInput;
import com.ar.genesis.sistema.service.dto.ProvinciaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CrearProvinciaController {
    @Inject
    ICrearProvinciaInput iCrearProvinciaInput;

    public CrearProvinciaController(ICrearProvinciaInput iCrearProvinciaInput) {
        this.iCrearProvinciaInput = iCrearProvinciaInput;
    }

    @PostMapping(value = "/Provincia")
    public ResponseEntity<?> crearProvincia(@RequestBody ProvinciaDTO provinciaDTO){
        try{
            boolean resultado = this.iCrearProvinciaInput.crearProvincia(Provincia.instancia(provinciaDTO.getId(), provinciaDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ProvinciaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}