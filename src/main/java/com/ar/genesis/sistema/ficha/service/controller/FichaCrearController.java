package com.ar.genesis.sistema.ficha.service.controller;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.ficha.core.exception.FichaExisteException;
import com.ar.genesis.sistema.ficha.core.input.IFichaCrearInput;
import com.ar.genesis.sistema.ficha.service.dto.FichaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class FichaCrearController {
    @Inject
    IFichaCrearInput miFichaCrearInput;

    public FichaCrearController(IFichaCrearInput miFichaCrearInput) {
        this.miFichaCrearInput = miFichaCrearInput;
    }

    @PostMapping(value = "/ficha")
    public ResponseEntity<?> crearFicha(@RequestBody FichaDTO unaFichaDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miFichaCrearInput.crearFicha(modelMapper.map(unaFichaDTO, Ficha.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (FichaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}