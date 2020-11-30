package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.core.input.IProvinciaModificarInput;
import com.ar.genesis.sistema.service.dto.ProvinciaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProvinciaModificarController {
    @Inject
    IProvinciaModificarInput miProvinciaModificarInput;

    public ProvinciaModificarController(IProvinciaModificarInput miProvinciaModificarInput) { this.miProvinciaModificarInput = miProvinciaModificarInput; }

    @PutMapping(value = "/Provincia")
    public ResponseEntity<?> modificarProvincia(@RequestBody ProvinciaDTO unProvinciaDTO){
        try{
            boolean resultado = this.miProvinciaModificarInput.modificarProvincia(Provincia.instancia(unProvinciaDTO.getId(), unProvinciaDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ProvinciaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
