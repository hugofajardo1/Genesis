package com.ar.genesis.sistema.tipomovimiento.service.controller;

import com.ar.genesis.sistema.tipomovimiento.core.input.ITipoMovimientoObtenerInput;
import com.ar.genesis.sistema.tipomovimiento.service.dto.TipoMovimientoDTO;
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
    ITipoMovimientoObtenerInput miTipoMovimientoObtenerInput;

    public TipoMovimientoObtenerController(ITipoMovimientoObtenerInput miTipoMovimientoObtenerInput) { this.miTipoMovimientoObtenerInput = miTipoMovimientoObtenerInput; }

    @GetMapping(value = "/tipomovimiento")
    public ResponseEntity<?> obtenerTipoMovimientos(){
        try{
            List<TipoMovimientoDTO> tipoMovimientosDTO = new ArrayList<>();
            miTipoMovimientoObtenerInput.obtenerTipoMovimientos().forEach(unTipoMovimiento -> tipoMovimientosDTO.add(new TipoMovimientoDTO(unTipoMovimiento.getId(), unTipoMovimiento.getNombre())));
            if (tipoMovimientosDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(tipoMovimientosDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
