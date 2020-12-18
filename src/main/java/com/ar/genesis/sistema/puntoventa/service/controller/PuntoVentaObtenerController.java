package com.ar.genesis.sistema.puntoventa.service.controller;

import com.ar.genesis.sistema.puntoventa.core.input.IPuntoVentaObtenerInput;
import com.ar.genesis.sistema.puntoventa.service.dto.PuntoVentaDTO;
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
public class PuntoVentaObtenerController {
    @Inject
    IPuntoVentaObtenerInput miPuntoVentaObtenerInput;

    public PuntoVentaObtenerController(IPuntoVentaObtenerInput miPuntoVentaObtenerInput) {
        this.miPuntoVentaObtenerInput = miPuntoVentaObtenerInput;
    }
    @GetMapping(value = "/puntoventa")
    public ResponseEntity<?> obtenerPuntoVentas(){
        try{
            List<PuntoVentaDTO> puntoventasDTO = new ArrayList<>();
            miPuntoVentaObtenerInput.obtenerPuntoVentas().forEach(unPuntoVenta -> puntoventasDTO.add(new PuntoVentaDTO(unPuntoVenta.getId(), unPuntoVenta.getNombre(), unPuntoVenta.getTipoFacturacion())));
            if (puntoventasDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(puntoventasDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
