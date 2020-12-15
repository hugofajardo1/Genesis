package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.input.ISucursalObtenerInput;
import com.ar.genesis.sistema.service.dto.SucursalDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class SucursalObtenerController {
    @Inject
    ISucursalObtenerInput miSucursalObtenerInput;

    public SucursalObtenerController(ISucursalObtenerInput miSucursalObtenerInput) { this.miSucursalObtenerInput = miSucursalObtenerInput; }

    @GetMapping(value = "/sucursal")
    public ResponseEntity<?> obtenerSucursales(){
        try{
            List<SucursalDTO> sucursalesDTO = new ArrayList<>();
            miSucursalObtenerInput.obtenerSucursales().forEach(unaSucursal -> sucursalesDTO.add(new SucursalDTO(unaSucursal.getId(), unaSucursal.getNombre())));
            if (sucursalesDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(sucursalesDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
