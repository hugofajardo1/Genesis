package com.ar.genesis.sistema.rubro.service.controller;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.exception.RubroExisteException;
import com.ar.genesis.sistema.rubro.core.input.IRubroCrearInput;
import com.ar.genesis.sistema.rubro.service.dto.RubroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class RubroCrearController {
    @Inject
    IRubroCrearInput miRubroCrearInput;

    public RubroCrearController(IRubroCrearInput miRubroCrearInput) {
        this.miRubroCrearInput = miRubroCrearInput;
    }

    @PostMapping(value = "/rubro")
    public ResponseEntity<?> crearRubro(@RequestBody RubroDTO unRubroDTO){
        try{
            boolean resultado = this.miRubroCrearInput.crearRubro(Rubro.instancia(unRubroDTO.getId(), unRubroDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (RubroExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}