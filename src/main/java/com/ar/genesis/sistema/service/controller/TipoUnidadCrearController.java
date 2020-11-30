package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.exception.TipoUnidadExisteException;
import com.ar.genesis.sistema.core.input.ITipoUnidadCrearInput;
import com.ar.genesis.sistema.service.dto.TipoUnidadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TipoUnidadCrearController {
    @Inject
    ITipoUnidadCrearInput miTipoUnidadCrearInput;

    public TipoUnidadCrearController(ITipoUnidadCrearInput miTipoUnidadCrearInput) { this.miTipoUnidadCrearInput = miTipoUnidadCrearInput; }

    @PostMapping(value = "/TipoUnidad")
    public ResponseEntity<?> crearTipoUnidad(@RequestBody TipoUnidadDTO unTipoUnidadDTO){
        try{
            boolean resultado = this.miTipoUnidadCrearInput.crearTipoUnidad(TipoUnidad.instancia(unTipoUnidadDTO.getId(), unTipoUnidadDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoUnidadExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
