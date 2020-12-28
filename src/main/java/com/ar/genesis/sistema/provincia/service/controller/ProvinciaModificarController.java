package com.ar.genesis.sistema.provincia.service.controller;

import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.provincia.core.exception.ProvinciaExisteException;
import com.ar.genesis.sistema.provincia.core.input.IProvinciaModificarInput;
import com.ar.genesis.sistema.provincia.service.dto.ProvinciaDTO;
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
public class ProvinciaModificarController {
    @Inject
    IProvinciaModificarInput miProvinciaModificarInput;

    public ProvinciaModificarController(IProvinciaModificarInput miProvinciaModificarInput) { this.miProvinciaModificarInput = miProvinciaModificarInput; }

    @PutMapping(value = "/provincia")
    public ResponseEntity<?> modificarProvincia(@RequestBody ProvinciaDTO unaProvinciaDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miProvinciaModificarInput.modificarProvincia(modelMapper.map(unaProvinciaDTO, Provincia.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ProvinciaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
