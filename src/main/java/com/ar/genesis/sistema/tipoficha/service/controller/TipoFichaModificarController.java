package com.ar.genesis.sistema.tipoficha.service.controller;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;
import com.ar.genesis.sistema.tipoficha.core.exception.TipoFichaExisteException;
import com.ar.genesis.sistema.tipoficha.core.input.ITipoFichaModificarInput;
import com.ar.genesis.sistema.tipoficha.service.dto.TipoFichaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TipoFichaModificarController {
    @Inject
    ITipoFichaModificarInput miTipoFichaModificarInput;

    public TipoFichaModificarController(ITipoFichaModificarInput miTipoFichaModificarInput) { this.miTipoFichaModificarInput = miTipoFichaModificarInput; }

    @PutMapping(value = "/tipoficha")
    public ResponseEntity<?> modificarTipoFicha(@RequestBody TipoFichaDTO unTipoFichaDTO){
        try{
            boolean resultado = this.miTipoFichaModificarInput.modificarTipoFicha(TipoFicha.instancia(unTipoFichaDTO.getId(), unTipoFichaDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoFichaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
