package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.exception.UbicacionExisteException;
import com.ar.genesis.sistema.core.input.ICrearUbicacionInput;
import com.ar.genesis.sistema.service.dto.UbicacionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CrearUbicacionController {
    @Inject
    ICrearUbicacionInput iCrearUbicacionInput;

    public CrearUbicacionController(ICrearUbicacionInput iCrearUbicacionInput) {
        this.iCrearUbicacionInput = iCrearUbicacionInput;
    }

    @PostMapping(value = "/Ubicacion")
    public ResponseEntity<?> crearUbicacion(@RequestBody UbicacionDTO ubicacionDTO){
        try{
            boolean resultado = this.iCrearUbicacionInput.crearUbicacion(Ubicacion.instancia(ubicacionDTO.getId(), ubicacionDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (UbicacionExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}