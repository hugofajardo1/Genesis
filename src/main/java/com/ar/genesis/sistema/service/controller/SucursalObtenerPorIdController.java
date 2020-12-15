package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Sucursal;
import com.ar.genesis.sistema.core.exception.SucursalNoExisteException;
import com.ar.genesis.sistema.core.input.ISucursalObtenerPorIdInput;
import com.ar.genesis.sistema.service.dto.SucursalDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class SucursalObtenerPorIdController {
    @Inject
    ISucursalObtenerPorIdInput miSucursalObtenerPorIdInput;

    public SucursalObtenerPorIdController(ISucursalObtenerPorIdInput miSucursalObtenerPorIdInput) { this.miSucursalObtenerPorIdInput = miSucursalObtenerPorIdInput; }

    @GetMapping(value = "/sucursal/id/{id}")
    public ResponseEntity<?> obtenerSucursal(@PathVariable Integer id){
        try{
            Sucursal unaSucursal = miSucursalObtenerPorIdInput.obtenerSucursal(id);
            SucursalDTO unaSucursalDTO=null;
            if (unaSucursal!=null){
                unaSucursalDTO = new SucursalDTO(unaSucursal.getId(), unaSucursal.getNombre());
            }
            return ResponseEntity.status(HttpStatus.OK).body(unaSucursalDTO);
        } catch (SucursalNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}