package com.ar.genesis.sistema.sucursal.service.controller;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.sucursal.core.exception.SucursalExisteException;
import com.ar.genesis.sistema.sucursal.core.input.ISucursalModificarInput;
import com.ar.genesis.sistema.sucursal.service.dto.SucursalDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class SucursalModificarController {
    @Inject
    ISucursalModificarInput miSucursalModificarInput;

    public SucursalModificarController(ISucursalModificarInput miSucursalModificarInput) { this.miSucursalModificarInput = miSucursalModificarInput; }

    @PutMapping(value = "/sucursal")
    public ResponseEntity<?> modificarSucursal(@RequestBody SucursalDTO unaSucursalDTO ){
        try{
            ModelMapper modelMapper = new ModelMapper();
            boolean resultado = this.miSucursalModificarInput.modificarSucursal(modelMapper.map(unaSucursalDTO, Sucursal.class));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (SucursalExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
