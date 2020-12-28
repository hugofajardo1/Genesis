package com.ar.genesis.sistema.ubicacion.service.controller;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import com.ar.genesis.sistema.ubicacion.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.ubicacion.core.input.IUbicacionModificarInput;
import com.ar.genesis.sistema.ubicacion.service.dto.UbicacionDTO;
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
public class UbicacionModificarController {
    @Inject
    IUbicacionModificarInput miUbicacionModificarInput;

    public UbicacionModificarController(IUbicacionModificarInput miUbicacionModificarInput) { this.miUbicacionModificarInput = miUbicacionModificarInput; }

    @PutMapping(value = "/ubicacion")
    public ResponseEntity<?> modificarUbicacion(@RequestBody UbicacionDTO unaUbicacionDTO ){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miUbicacionModificarInput.modificarUbicacion(modelMapper.map(unaUbicacionDTO, Ubicacion.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (UbicacionExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
