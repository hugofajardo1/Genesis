package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.exception.TipoMovimientoExisteException;
import com.ar.genesis.sistema.core.input.ICrearTipoMovimientoInput;
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
public class CrearTipoMovimientoController {
    @Inject
    ICrearTipoMovimientoInput iCrearTipoMovimientoInput;

    public CrearTipoMovimientoController(ICrearTipoMovimientoInput iCrearTipoMovimientoInput) {
        this.iCrearTipoMovimientoInput = iCrearTipoMovimientoInput;
    }
    @PostMapping(value = "/TipoMovimiento")
    public ResponseEntity<?> crearTipoMovimiento(@RequestBody TipoMovimientoDTO TipoMovimientoDTO){
        try{
            boolean resultado = this.iCrearTipoMovimientoInput.crearTipoMovimiento(TipoMovimiento.instancia(TipoMovimientoDTO.getId(), TipoMovimientoDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoMovimientoExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}