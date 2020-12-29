package com.ar.genesis.sistema.tipooperacion.service.controller;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.exception.TipoOperacionExisteException;
import com.ar.genesis.sistema.tipooperacion.core.input.ITipoOperacionCrearInput;
import com.ar.genesis.sistema.tipooperacion.service.dto.TipoOperacionDTO;
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
public class TipoOperacionCrearController {
    @Inject
    ITipoOperacionCrearInput miTipoOperacionCrearInput;

    public TipoOperacionCrearController(ITipoOperacionCrearInput miTipoOperacionCrearInput) { this.miTipoOperacionCrearInput = miTipoOperacionCrearInput; }

    @PostMapping(value = "/tipooperacion")
    public ResponseEntity<?> crearTipoOperacion(@RequestBody TipoOperacionDTO unTipoOperacionDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miTipoOperacionCrearInput.crearTipoOperacion(modelMapper.map(unTipoOperacionDTO, TipoOperacion.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoOperacionExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
