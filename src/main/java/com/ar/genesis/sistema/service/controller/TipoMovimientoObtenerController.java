package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.input.IObtenerTipoMovimientosInput;
import com.ar.genesis.sistema.service.dto.TipoMovimientoDTO;
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
public class TipoMovimientoObtenerController {
    @Inject
    IObtenerTipoMovimientosInput miObtenerTipoMovimientosInput;

    public TipoMovimientoObtenerController(IObtenerTipoMovimientosInput miObtenerTipoMovimientosInput) { this.miObtenerTipoMovimientosInput = miObtenerTipoMovimientosInput; }

    @GetMapping(value = "/TipoMovimientos")
    public ResponseEntity<?> obtenerTipoMovimientos(){
        try{
            List<TipoMovimientoDTO> tipoMovimientosDTO = new ArrayList<>();
            miObtenerTipoMovimientosInput.obtenerTipoMovimientos().forEach(unTipoMovimiento -> tipoMovimientosDTO.add(new TipoMovimientoDTO(unTipoMovimiento.getId(), unTipoMovimiento.getNombre())));
            if (tipoMovimientosDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(tipoMovimientosDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
