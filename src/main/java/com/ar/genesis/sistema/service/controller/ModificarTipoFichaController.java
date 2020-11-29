package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.TipoFicha;
import com.ar.genesis.sistema.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.core.input.IModificarTipoFichaInput;
import com.ar.genesis.sistema.service.dto.TipoFichaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ModificarTipoFichaController {
    @Inject
    IModificarTipoFichaInput iModificarTipoFichaInput;

    public ModificarTipoFichaController(IModificarTipoFichaInput iModificarTipoFichaInput) {
        this.iModificarTipoFichaInput = iModificarTipoFichaInput;
    }
    @PutMapping(value = "/TipoFicha")
    public ResponseEntity<?> modificarTipoFicha(@RequestBody TipoFichaDTO tipoFichaDTO){
        try{
            boolean resultado = this.iModificarTipoFichaInput.modificarTipoFicha(TipoFicha.instancia(tipoFichaDTO.getId(), tipoFichaDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoFichaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
