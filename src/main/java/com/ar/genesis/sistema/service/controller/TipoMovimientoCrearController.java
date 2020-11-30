package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.exception.TipoMovimientoExisteException;
import com.ar.genesis.sistema.core.input.ITipoMovimientoCrearInput;
import com.ar.genesis.sistema.service.dto.TipoMovimientoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TipoMovimientoCrearController {
    @Inject
    ITipoMovimientoCrearInput miTipoMovimientoCrearInput;

    public TipoMovimientoCrearController(ITipoMovimientoCrearInput miTipoMovimientoCrearInput) { this.miTipoMovimientoCrearInput = miTipoMovimientoCrearInput; }

    @PostMapping(value = "/TipoMovimiento")
    public ResponseEntity<?> crearTipoMovimiento(@RequestBody TipoMovimientoDTO unTipoMovimientoDTO){
        try{
            boolean resultado = this.miTipoMovimientoCrearInput.crearTipoMovimiento(TipoMovimiento.instancia(unTipoMovimientoDTO.getId(), unTipoMovimientoDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoMovimientoExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
