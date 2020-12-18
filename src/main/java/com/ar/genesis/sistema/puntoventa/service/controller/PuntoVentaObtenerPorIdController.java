package com.ar.genesis.sistema.puntoventa.service.controller;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.exception.PuntoVentaNoExisteException;
import com.ar.genesis.sistema.puntoventa.core.input.IPuntoVentaObtenerPorIdInput;
import com.ar.genesis.sistema.puntoventa.service.dto.PuntoVentaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PuntoVentaObtenerPorIdController {
    @Inject
    IPuntoVentaObtenerPorIdInput miPuntoVentaObtenerPorIdInput;

    public PuntoVentaObtenerPorIdController(IPuntoVentaObtenerPorIdInput miPuntoVentaObtenerPorIdInput) { this.miPuntoVentaObtenerPorIdInput = miPuntoVentaObtenerPorIdInput; }

    @GetMapping(value = "/puntoventa/id/{id}")
    public ResponseEntity<?> obtenerPuntoVenta(@PathVariable Integer id){
        try{
            PuntoVenta unPuntoVenta = miPuntoVentaObtenerPorIdInput.obtenerPuntoVenta(id);
            PuntoVentaDTO unPuntoVentaDTO=null;
            if (unPuntoVenta!=null){
                unPuntoVentaDTO = new PuntoVentaDTO(unPuntoVenta.getId(), unPuntoVenta.getNombre(), unPuntoVenta.getTipoFacturacion());
            }
            return ResponseEntity.status(HttpStatus.OK).body(unPuntoVentaDTO);
        } catch (PuntoVentaNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}