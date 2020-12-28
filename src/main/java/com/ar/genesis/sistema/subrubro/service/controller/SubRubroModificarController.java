package com.ar.genesis.sistema.subrubro.service.controller;

import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.subrubro.core.exception.SubRubroExisteException;
import com.ar.genesis.sistema.subrubro.core.input.ISubRubroModificarInput;
import com.ar.genesis.sistema.subrubro.service.dto.SubRubroDTO;
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
public class SubRubroModificarController {
    @Inject
    ISubRubroModificarInput miSubRubroModificarInput;

    public SubRubroModificarController(ISubRubroModificarInput miSubRubroModificarInput) { this.miSubRubroModificarInput = miSubRubroModificarInput; }

    @PutMapping(value = "/subrubro")
    public ResponseEntity<?> modificarSubRubro(@RequestBody SubRubroDTO unSubRubroDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miSubRubroModificarInput.modificarSubRubro(modelMapper.map(unSubRubroDTO, SubRubro.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (SubRubroExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
