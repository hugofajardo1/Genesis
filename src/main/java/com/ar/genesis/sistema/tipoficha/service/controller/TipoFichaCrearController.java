package com.ar.genesis.sistema.tipoficha.service.controller;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;
import com.ar.genesis.sistema.tipoficha.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.tipoficha.core.input.ITipoFichaCrearInput;
import com.ar.genesis.sistema.tipoficha.service.dto.TipoFichaDTO;
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
public class TipoFichaCrearController {
    @Inject
    ITipoFichaCrearInput miTipoFichaCrearInput;

    public TipoFichaCrearController(ITipoFichaCrearInput miTipoFichaCrearInput) { this.miTipoFichaCrearInput = miTipoFichaCrearInput; }

    @PostMapping(value = "/tipoficha")
    public ResponseEntity<?> crearTipoFicha(@RequestBody TipoFichaDTO unTipoFichaDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miTipoFichaCrearInput.crearTipoFicha(modelMapper.map(unTipoFichaDTO, TipoFicha.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoFichaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}