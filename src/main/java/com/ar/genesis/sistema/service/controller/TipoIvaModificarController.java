package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.core.input.IModificarTipoIvaInput;
import com.ar.genesis.sistema.service.dto.TipoIvaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TipoIvaModificarController {
    @Inject
    IModificarTipoIvaInput miModificarTipoIvaInput;

    public TipoIvaModificarController(IModificarTipoIvaInput miModificarTipoIvaInput) { this.miModificarTipoIvaInput = miModificarTipoIvaInput; }

    @PutMapping(value = "/TipoIva")
    public ResponseEntity<?> modificarTipoIva(@RequestBody TipoIvaDTO unTipoIvaDTO){
        try{
            boolean resultado = this.miModificarTipoIvaInput.modificarTipoIva(TipoIva.instancia(unTipoIvaDTO.getId(), unTipoIvaDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoIvaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
