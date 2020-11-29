package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.exception.TipoMovimientoExisteException;
import com.ar.genesis.sistema.core.input.IModificarTipoMovimientoInput;
import com.ar.genesis.sistema.service.dto.TipoMovimientoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ModificarTipoMovimientoController {
    @Inject
    IModificarTipoMovimientoInput iModificarTipoMovimientoInput;

    public ModificarTipoMovimientoController(IModificarTipoMovimientoInput iModificarTipoMovimientoInput) {
        this.iModificarTipoMovimientoInput = iModificarTipoMovimientoInput;
    }
    @PutMapping(value = "/TipoMovimiento")
    public ResponseEntity<?> modificarTipoMovimiento(@RequestBody TipoMovimientoDTO tipoMovimientoDTO){
        try{
            boolean resultado = this.iModificarTipoMovimientoInput.modificarTipoMovimiento(TipoMovimiento.instancia(tipoMovimientoDTO.getId(), tipoMovimientoDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoMovimientoExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
