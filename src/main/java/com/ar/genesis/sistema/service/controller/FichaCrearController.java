package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.domain.TipoIva;
import com.ar.genesis.sistema.core.exception.FichaExisteException;
import com.ar.genesis.sistema.core.input.ICrearFichaInput;
import com.ar.genesis.sistema.service.dto.FichaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class FichaCrearController {
    @Inject
    ICrearFichaInput miCrearFichaInput;

    public FichaCrearController(ICrearFichaInput miCrearFichaInput) {
        this.miCrearFichaInput = miCrearFichaInput;
    }

    @PostMapping(value = "/Ficha")
    public ResponseEntity<?> crearFicha(@RequestBody FichaDTO unaFichaDTO){
        try{
            boolean resultado = this.miCrearFichaInput.crearFicha(Ficha.instancia(unaFichaDTO.getId(), unaFichaDTO.getNombre(), unaFichaDTO.getDomicilio(), unaFichaDTO.getTelefono(), TipoIva.instancia(1, "Responsable Inscripto"), "20255071336"));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (FichaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}