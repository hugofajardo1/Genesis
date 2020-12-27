package com.ar.genesis.sistema.movimiento.service.controller;

import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import com.ar.genesis.sistema.movimiento.core.exception.MovimientoNoExisteException;
import com.ar.genesis.sistema.movimiento.core.input.IMovimientoObtenerPorIdInput;
import com.ar.genesis.sistema.movimiento.service.dto.MovimientoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class MovimientoObtenerPorIdController {
    @Inject
    IMovimientoObtenerPorIdInput miMovimientoObtenerPorIdInput;

    public MovimientoObtenerPorIdController(IMovimientoObtenerPorIdInput miMovimientoObtenerPorIdInput) { this.miMovimientoObtenerPorIdInput = miMovimientoObtenerPorIdInput; }

    @GetMapping(value = "/movimiento/id/{id}")
    public ResponseEntity<?> obtenerMovimiento(@PathVariable Integer id){
        try{
            Movimiento unMovimiento = miMovimientoObtenerPorIdInput.obtenerMovimiento(id);
            MovimientoDTO unMovimientoDTO=null;
            if (unMovimiento!=null){
                ModelMapper modelMapper = new ModelMapper();
                unMovimientoDTO = modelMapper.map(unMovimiento, MovimientoDTO.class);
            }
            return ResponseEntity.status(HttpStatus.OK).body(unMovimientoDTO);
        } catch (MovimientoNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}