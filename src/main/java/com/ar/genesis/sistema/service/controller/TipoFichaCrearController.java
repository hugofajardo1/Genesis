package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.core.input.ICrearTipoFichaInput;
import com.ar.genesis.sistema.service.dto.TipoFichaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TipoFichaCrearController {
    @Inject
    ICrearTipoFichaInput miCrearTipoFichaInput;

    public TipoFichaCrearController(ICrearTipoFichaInput miCrearTipoFichaInput) { this.miCrearTipoFichaInput = miCrearTipoFichaInput; }

    @PostMapping(value = "/TipoFicha")
    public ResponseEntity<?> crearTipoFicha(@RequestBody TipoFichaDTO unTipoFichaDTO){
        try{
            boolean resultado = this.miCrearTipoFichaInput.crearTipoFicha(TipoFicha.instancia(unTipoFichaDTO.getId(), unTipoFichaDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoFichaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}