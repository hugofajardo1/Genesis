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
public class ModificarTipoIvaController {
    @Inject
    IModificarTipoIvaInput iModificarTipoIvaInput;

    public ModificarTipoIvaController(IModificarTipoIvaInput iModificarTipoIvaInput) {
        this.iModificarTipoIvaInput = iModificarTipoIvaInput;
    }
    @PutMapping(value = "/TipoIva")
    public ResponseEntity<?> modificarTipoIva(@RequestBody TipoIvaDTO TipoIvaDTO){
        try{
            boolean resultado = this.iModificarTipoIvaInput.modificarTipoIva(TipoIva.instancia(TipoIvaDTO.getId(), TipoIvaDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoIvaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
