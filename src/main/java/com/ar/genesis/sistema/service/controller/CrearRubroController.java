package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.exception.RubroExisteException;
import com.ar.genesis.sistema.core.input.ICrearRubroInput;
import com.ar.genesis.sistema.service.dto.RubroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CrearRubroController {
    @Inject
    ICrearRubroInput iCrearRubroInput;

    public CrearRubroController(ICrearRubroInput iCrearRubroInput) {
        this.iCrearRubroInput = iCrearRubroInput;
    }

    @PostMapping(value = "/Rubro")
    public ResponseEntity<?> crearRubro(@RequestBody RubroDTO RubroDTO){
        try{
            boolean resultado = this.iCrearRubroInput.crearRubro(Rubro.instancia(RubroDTO.getId(), RubroDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (RubroExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}