package com.ar.genesis.sistema.puntoventa.service.controller;


import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.exception.PuntoVentaExisteException;
import com.ar.genesis.sistema.puntoventa.core.input.IPuntoVentaCrearInput;
import com.ar.genesis.sistema.puntoventa.service.dto.PuntoVentaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PuntoVentaCrearController {
    @Inject
    IPuntoVentaCrearInput miPuntoVentaCrearInput;

    public PuntoVentaCrearController(IPuntoVentaCrearInput miPuntoVentaCrearInput) {
        this.miPuntoVentaCrearInput = miPuntoVentaCrearInput;
    }

    @PostMapping(value = "/puntoventa")
    public ResponseEntity<?> crearPuntoVenta(@RequestBody PuntoVentaDTO unPuntoVentaDTO){
        try{
            boolean resultado = this.miPuntoVentaCrearInput.crearPuntoVenta(PuntoVenta.instancia(unPuntoVentaDTO.getId(), unPuntoVentaDTO.getNombre(), unPuntoVentaDTO.getTipofacturacion()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (PuntoVentaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}