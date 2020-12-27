package com.ar.genesis.sistema.localidad.service.controller;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.localidad.core.exception.LocalidadExisteException;
import com.ar.genesis.sistema.localidad.core.input.ILocalidadModificarInput;
import com.ar.genesis.sistema.localidad.service.dto.LocalidadDTO;
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
public class LocalidadModificarController {
    @Inject
    ILocalidadModificarInput miLocalidadModificarInput;

    public LocalidadModificarController(ILocalidadModificarInput miLocalidadModificarInput) { this.miLocalidadModificarInput = miLocalidadModificarInput; }

    @PutMapping(value = "/localidad")
    public ResponseEntity<?> modificarLocalidad(@RequestBody LocalidadDTO unaLocalidadDTO ){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miLocalidadModificarInput.modificarLocalidad(modelMapper.map(unaLocalidadDTO, Localidad.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LocalidadExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
