package com.ar.genesis.sistema.movimiento.service.controller;

import com.ar.genesis.sistema.movimiento.core.exception.MovimientoExisteException;
import com.ar.genesis.sistema.movimiento.core.exception.MovimientoIncompletoException;
import com.ar.genesis.sistema.movimiento.core.input.IMovimientoCrearInput;
import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import com.ar.genesis.sistema.movimiento.service.dto.MovimientoDTO;
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
public class MovimientoCrearController {
    @Inject
    IMovimientoCrearInput miMovimientoCrearInput;

    public MovimientoCrearController(IMovimientoCrearInput miMovimientoCrearInput) {
        this.miMovimientoCrearInput = miMovimientoCrearInput;
    }

    @PostMapping(value = "/movimiento")
    public ResponseEntity<?> crearMovimiento(@RequestBody MovimientoDTO unMovimientoDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miMovimientoCrearInput.crearMovimiento(modelMapper.map(unMovimientoDTO, Movimiento.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (MovimientoExisteException | MovimientoIncompletoException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}