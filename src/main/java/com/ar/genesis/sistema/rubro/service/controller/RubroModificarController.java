package com.ar.genesis.sistema.rubro.service.controller;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.exception.RubroExisteException;
import com.ar.genesis.sistema.rubro.core.input.IRubroModificarInput;
import com.ar.genesis.sistema.rubro.service.dto.RubroDTO;
import org.modelmapper.ModelMapper;
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
    IRubroModificarInput miRubroModificarInput;

    public RubroModificarController(IRubroModificarInput miRubroModificarInput) { this.miRubroModificarInput = miRubroModificarInput; }

    @PutMapping(value = "/rubro")
    public ResponseEntity<?> modificarRubro(@RequestBody RubroDTO unRubroDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miRubroModificarInput.modificarRubro(modelMapper.map(unRubroDTO, Rubro.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (RubroExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
