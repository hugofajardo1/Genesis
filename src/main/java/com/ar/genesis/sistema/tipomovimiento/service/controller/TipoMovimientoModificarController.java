package com.ar.genesis.sistema.tipomovimiento.service.controller;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.core.exception.TipoMovimientoExisteException;
import com.ar.genesis.sistema.tipomovimiento.core.input.ITipoMovimientoModificarInput;
import com.ar.genesis.sistema.tipomovimiento.service.dto.TipoMovimientoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TipoMovimientoModificarController {
    @Inject
    ITipoMovimientoModificarInput miTipoMovimientoModificarInput;

    public TipoMovimientoModificarController(ITipoMovimientoModificarInput miTipoMovimientoModificarInput) { this.miTipoMovimientoModificarInput = miTipoMovimientoModificarInput; }

    @PutMapping(value = "/tipomovimiento")
    public ResponseEntity<?> modificarTipoMovimiento(@RequestBody TipoMovimientoDTO unTipoMovimientoDTO){
        try{
            boolean resultado = this.miTipoMovimientoModificarInput.modificarTipoMovimiento(TipoMovimiento.instancia(unTipoMovimientoDTO.getId(), unTipoMovimientoDTO.getNombre(), unTipoMovimientoDTO.getImputacion()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoMovimientoExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
