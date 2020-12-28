package com.ar.genesis.sistema.tipoiva.service.controller;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipoiva.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.tipoiva.core.input.ITipoIvaModificarInput;
import com.ar.genesis.sistema.tipoiva.service.dto.TipoIvaDTO;
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
public class TipoIvaModificarController {
    @Inject
    ITipoIvaModificarInput miTipoIvaModificarInput;

    public TipoIvaModificarController(ITipoIvaModificarInput miTipoIvaModificarInput) { this.miTipoIvaModificarInput = miTipoIvaModificarInput; }

    @PutMapping(value = "/tipoiva")
    public ResponseEntity<?> modificarTipoIva(@RequestBody TipoIvaDTO unTipoIvaDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miTipoIvaModificarInput.modificarTipoIva(modelMapper.map(unTipoIvaDTO, TipoIva.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoIvaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
