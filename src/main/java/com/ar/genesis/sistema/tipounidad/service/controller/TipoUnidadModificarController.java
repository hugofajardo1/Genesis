package com.ar.genesis.sistema.tipounidad.service.controller;

import com.ar.genesis.sistema.tipounidad.core.domain.TipoUnidad;
import com.ar.genesis.sistema.tipounidad.core.exception.TipoUnidadExisteException;
import com.ar.genesis.sistema.tipounidad.core.input.ITipoUnidadModificarInput;
import com.ar.genesis.sistema.tipounidad.service.dto.TipoUnidadDTO;
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
    ITipoUnidadModificarInput miTipoUnidadModificarInput;

    public TipoUnidadModificarController(ITipoUnidadModificarInput miTipoUnidadModificarInput) { this.miTipoUnidadModificarInput = miTipoUnidadModificarInput; }

    @PutMapping(value = "/tipounidad")
    public ResponseEntity<?> modificarTipoUnidad(@RequestBody TipoUnidadDTO unTipoUnidadDTO){
        try{
            boolean resultado = this.miTipoUnidadModificarInput.modificarTipoUnidad(TipoUnidad.instancia(unTipoUnidadDTO.getId(), unTipoUnidadDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoUnidadExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
