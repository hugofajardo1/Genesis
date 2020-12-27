package com.ar.genesis.sistema.localidad.service.controller;

import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.localidad.core.exception.LocalidadExisteException;
import com.ar.genesis.sistema.localidad.core.input.ILocalidadCrearInput;
import com.ar.genesis.sistema.localidad.service.dto.LocalidadDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class LocalidadCrearController {
    @Inject
    ILocalidadCrearInput miLocalidadCrearInput;

    public LocalidadCrearController(ILocalidadCrearInput miLocalidadCrearInput) { this.miLocalidadCrearInput = miLocalidadCrearInput; }

    @PostMapping(value = "/localidad")
    public ResponseEntity<?> crearLocalidad(@RequestBody LocalidadDTO unaLocalidadDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miLocalidadCrearInput.crearLocalidad(modelMapper.map(unaLocalidadDTO, Localidad.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LocalidadExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}