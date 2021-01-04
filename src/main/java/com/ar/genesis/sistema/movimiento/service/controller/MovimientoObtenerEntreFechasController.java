package com.ar.genesis.sistema.movimiento.service.controller;

import com.ar.genesis.sistema.movimiento.core.input.IMovimientoObtenerEntreFechasInput;
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
public class MovimientoObtenerEntreFechasController {
    @Inject
    IMovimientoObtenerEntreFechasInput miMovimientoObtenerEntreFechasInput;

    public MovimientoObtenerEntreFechasController(IMovimientoObtenerEntreFechasInput miMovimientoObtenerEntreFechasInput) { this.miMovimientoObtenerEntreFechasInput = miMovimientoObtenerEntreFechasInput; }

    @GetMapping(value = "/movimiento/desde/{desde}/hasta/{hasta}")
    public ResponseEntity<?> obtenerMovimientosEntreFechas(@PathVariable LocalDate desde, LocalDate hasta){
        try{
            ModelMapper modelMapper = new ModelMapper();
            List<MovimientoDTO> movimientosDTO = new ArrayList<>();
            miMovimientoObtenerEntreFechasInput.obtenerMovimientosEntreFechas(desde, hasta).forEach(unMovimiento -> movimientosDTO.add(modelMapper.map(unMovimiento, MovimientoDTO.class)));
            if (movimientosDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(movimientosDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}