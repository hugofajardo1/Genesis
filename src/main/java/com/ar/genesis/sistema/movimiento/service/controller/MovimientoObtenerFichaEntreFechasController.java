package com.ar.genesis.sistema.movimiento.service.controller;

import com.ar.genesis.sistema.movimiento.core.input.IMovimientoObtenerFichaEntreFechasInput;
import com.ar.genesis.sistema.movimiento.service.dto.MovimientoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class MovimientoObtenerFichaEntreFechasController {
    @Inject
    IMovimientoObtenerFichaEntreFechasInput miMovimientoObtenerFichaEntreFechasInput;

    public MovimientoObtenerFichaEntreFechasController(IMovimientoObtenerFichaEntreFechasInput miMovimientoObtenerFichaEntreFechasInput) { this.miMovimientoObtenerFichaEntreFechasInput = miMovimientoObtenerFichaEntreFechasInput; }

    @GetMapping(value = "/movimiento/ficha/{fichaid}/desde/{desde}/hasta/{hasta}")
    public ResponseEntity<?> obtenerMovimientosFichaEntreFechas(@PathVariable Integer fichaid, @PathVariable LocalDate desde, @PathVariable LocalDate hasta){
        try{
            ModelMapper modelMapper = new ModelMapper();
            List<MovimientoDTO> movimientosDTO = new ArrayList<>();
            miMovimientoObtenerFichaEntreFechasInput.obtenerMovimientosFichaEntreFechas(fichaid, desde, hasta).forEach(unMovimiento -> movimientosDTO.add(modelMapper.map(unMovimiento, MovimientoDTO.class)));
            if (movimientosDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(movimientosDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}