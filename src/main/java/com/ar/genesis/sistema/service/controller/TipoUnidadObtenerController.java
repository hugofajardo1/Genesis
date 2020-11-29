package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.input.IObtenerTipoUnidadesInput;
import com.ar.genesis.sistema.service.dto.TipoUnidadDTO;
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
public class TipoUnidadObtenerController {
    @Inject
    IObtenerTipoUnidadesInput miObtenerTipoUnidadesInput;

    public TipoUnidadObtenerController(IObtenerTipoUnidadesInput miObtenerTipoUnidadesInput) { this.miObtenerTipoUnidadesInput = miObtenerTipoUnidadesInput; }

    @GetMapping(value = "/TipoUnidades")
    public ResponseEntity<?> obtenerTipoUnidades(){
        try{
            List<TipoUnidadDTO> tipoUnidadesDTO = new ArrayList<>();
            miObtenerTipoUnidadesInput.obtenerTipoUnidades().forEach(unTipoUnidad -> tipoUnidadesDTO.add(new TipoUnidadDTO(unTipoUnidad.getId(), unTipoUnidad.getNombre())));
            if (tipoUnidadesDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(tipoUnidadesDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}