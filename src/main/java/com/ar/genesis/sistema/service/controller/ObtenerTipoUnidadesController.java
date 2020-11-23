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
public class ObtenerTipoUnidadesController {
    @Inject
    IObtenerTipoUnidadesInput iObtenerTipoUnidadesInput;

    public ObtenerTipoUnidadesController(IObtenerTipoUnidadesInput iObtenerTipoUnidadesInput) {
        this.iObtenerTipoUnidadesInput = iObtenerTipoUnidadesInput;
    }
    @GetMapping(value = "/TipoUnidades")
    public ResponseEntity<?> obtenerTipoUnidades(){
        try{
            List<TipoUnidadDTO> tipoUnidadesDTO = new ArrayList<>();
            iObtenerTipoUnidadesInput.obtenerTipoUnidades().forEach(TipoUnidad -> tipoUnidadesDTO.add(new TipoUnidadDTO(TipoUnidad.getId(), TipoUnidad.getNombre())));
            if (tipoUnidadesDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(tipoUnidadesDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
