package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.core.input.ICrearTipoIvaInput;
import com.ar.genesis.sistema.service.dto.TipoIvaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CrearTipoIvaController {
    @Inject
    ICrearTipoIvaInput iCrearTipoIvaInput;

    public CrearTipoIvaController(ICrearTipoIvaInput iCrearTipoIvaInput) {
        this.iCrearTipoIvaInput = iCrearTipoIvaInput;
    }
    @PostMapping(value = "/TipoIva")
    public ResponseEntity<?> crearTipoIva(@RequestBody TipoIvaDTO tipoIvaDTO){
        try{
            boolean resultado = this.iCrearTipoIvaInput.crearTipoIva(TipoIva.instancia(tipoIvaDTO.getId(), tipoIvaDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoIvaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
