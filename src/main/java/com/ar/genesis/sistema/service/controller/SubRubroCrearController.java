package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.SubRubro;
import com.ar.genesis.sistema.core.exception.SubRubroExisteException;
import com.ar.genesis.sistema.core.input.ICrearSubRubroInput;
import com.ar.genesis.sistema.service.dto.SubRubroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class SubRubroCrearController {
    @Inject
    ICrearSubRubroInput miCrearSubRubroInput;

    public SubRubroCrearController(ICrearSubRubroInput miCrearSubRubroInput) { this.miCrearSubRubroInput = miCrearSubRubroInput; }

    @PostMapping(value = "/SubRubro")
    public ResponseEntity<?> crearSubRubro(@RequestBody SubRubroDTO unSubRubroDTO){
        try{
            boolean resultado = this.miCrearSubRubroInput.crearSubRubro(SubRubro.instancia(unSubRubroDTO.getId(), unSubRubroDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (SubRubroExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}