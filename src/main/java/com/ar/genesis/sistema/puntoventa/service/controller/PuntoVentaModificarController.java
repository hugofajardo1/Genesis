package com.ar.genesis.sistema.puntoventa.service.controller;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.exception.PuntoVentaExisteException;
import com.ar.genesis.sistema.puntoventa.core.input.IPuntoVentaModificarInput;
import com.ar.genesis.sistema.puntoventa.service.dto.PuntoVentaDTO;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PuntoVentaModificarController {
    @Inject
    IPuntoVentaModificarInput miPuntoVentaModificarInput;

    public PuntoVentaModificarController(IPuntoVentaModificarInput miPuntoVentaModificarInput) { this.miPuntoVentaModificarInput = miPuntoVentaModificarInput; }

    @PutMapping(value = "/puntoventa")
    public ResponseEntity<?> modificarPuntoVenta(@RequestBody PuntoVentaDTO unPuntoVentaDTO){
        try{
            boolean resultado = this.miPuntoVentaModificarInput.modificarPuntoVenta(PuntoVenta.instancia(unPuntoVentaDTO.getId(), unPuntoVentaDTO.getNombre(), Sucursal.instancia(unPuntoVentaDTO.getSucursal().getId(), unPuntoVentaDTO.getSucursal().getNombre()), unPuntoVentaDTO.getTipofacturacion()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (PuntoVentaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}
