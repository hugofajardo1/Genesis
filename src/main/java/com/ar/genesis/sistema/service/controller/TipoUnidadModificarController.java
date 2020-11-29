package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.exception.TipoUnidadExisteException;
import com.ar.genesis.sistema.core.input.IModificarTipoUnidadInput;
import com.ar.genesis.sistema.service.dto.TipoUnidadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TipoUnidadModificarController {
    @Inject
    IModificarTipoUnidadInput miModificarTipoUnidadInput;

    public TipoUnidadModificarController(IModificarTipoUnidadInput miModificarTipoUnidadInput) { this.miModificarTipoUnidadInput = miModificarTipoUnidadInput; }

    @PutMapping(value = "/TipoUnidad")
    public ResponseEntity<?> modificarTipoUnidad(@RequestBody TipoUnidadDTO unTipoUnidadDTO){
        try{
            boolean resultado = this.miModificarTipoUnidadInput.modificarTipoUnidad(TipoUnidad.instancia(unTipoUnidadDTO.getId(), unTipoUnidadDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoUnidadExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
