package com.ar.genesis.sistema.subrubro.service.controller;

import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.subrubro.core.exception.SubRubroExisteException;
import com.ar.genesis.sistema.subrubro.core.input.ISubRubroCrearInput;
import com.ar.genesis.sistema.subrubro.service.dto.SubRubroDTO;
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
    ISubRubroCrearInput miSubRubroCrearInput;

    public SubRubroCrearController(ISubRubroCrearInput miSubRubroCrearInput) { this.miSubRubroCrearInput = miSubRubroCrearInput; }

    @PostMapping(value = "/subrubro")
    public ResponseEntity<?> crearSubRubro(@RequestBody SubRubroDTO unSubRubroDTO){
        try{
            boolean resultado = this.miSubRubroCrearInput.crearSubRubro(SubRubro.instancia(unSubRubroDTO.getId(), unSubRubroDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (SubRubroExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}