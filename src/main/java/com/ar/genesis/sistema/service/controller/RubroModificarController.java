package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Rubro;
import com.ar.genesis.sistema.core.exception.RubroExisteException;
import com.ar.genesis.sistema.core.input.IModificarRubroInput;
import com.ar.genesis.sistema.service.dto.RubroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class RubroModificarController {
    @Inject
    IModificarRubroInput miModificarRubroInput;

    public RubroModificarController(IModificarRubroInput miModificarRubroInput) { this.miModificarRubroInput = miModificarRubroInput; }

    @PutMapping(value = "/Rubro")
    public ResponseEntity<?> modificarRubro(@RequestBody RubroDTO unRubroDTO){
        try{
            boolean resultado = this.miModificarRubroInput.modificarRubro(Rubro.instancia(unRubroDTO.getId(), unRubroDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (RubroExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
