package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.exception.LocalidadExisteException;
import com.ar.genesis.sistema.core.input.IModificarLocalidadInput;
import com.ar.genesis.sistema.service.dto.LocalidadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ModificarLocalidadController {
    @Inject
    IModificarLocalidadInput iModificarLocalidadInput;

    public ModificarLocalidadController(IModificarLocalidadInput iModificarLocalidadInput) {
        this.iModificarLocalidadInput = iModificarLocalidadInput;
    }
    @PutMapping(value = "/Localidad")
    public ResponseEntity<?> modificarLocalidad(@RequestBody LocalidadDTO localidadDTO ){
        try{
            boolean resultado = this.iModificarLocalidadInput.modificarLocalidad(Localidad.instancia(localidadDTO.getId(), localidadDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LocalidadExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}