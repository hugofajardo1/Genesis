package com.ar.genesis.sistema.tipoiva.service.controller;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipoiva.core.exception.TipoIvaExisteException;
import com.ar.genesis.sistema.tipoiva.core.input.ITipoIvaCrearInput;
import com.ar.genesis.sistema.tipoiva.service.dto.TipoIvaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TipoIvaCrearController {
    @Inject
    ITipoIvaCrearInput miTipoIvaCrearInput;

    public TipoIvaCrearController(ITipoIvaCrearInput miTipoIvaCrearInput) { this.miTipoIvaCrearInput = miTipoIvaCrearInput; }

    @PostMapping(value = "/tipoiva")
    public ResponseEntity<?> crearTipoIva(@RequestBody TipoIvaDTO unTipoIvaDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miTipoIvaCrearInput.crearTipoIva(modelMapper.map(unTipoIvaDTO, TipoIva.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoIvaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
