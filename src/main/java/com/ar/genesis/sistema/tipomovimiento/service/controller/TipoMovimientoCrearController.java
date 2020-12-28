package com.ar.genesis.sistema.tipomovimiento.service.controller;

import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.tipomovimiento.core.exception.TipoMovimientoExisteException;
import com.ar.genesis.sistema.tipomovimiento.core.input.ITipoMovimientoCrearInput;
import com.ar.genesis.sistema.tipomovimiento.service.dto.TipoMovimientoDTO;
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
public class TipoMovimientoCrearController {
    @Inject
    ITipoMovimientoCrearInput miTipoMovimientoCrearInput;

    public TipoMovimientoCrearController(ITipoMovimientoCrearInput miTipoMovimientoCrearInput) { this.miTipoMovimientoCrearInput = miTipoMovimientoCrearInput; }

    @PostMapping(value = "/tipomovimiento")
    public ResponseEntity<?> crearTipoMovimiento(@RequestBody TipoMovimientoDTO unTipoMovimientoDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miTipoMovimientoCrearInput.crearTipoMovimiento(modelMapper.map(unTipoMovimientoDTO, TipoMovimiento.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoMovimientoExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
