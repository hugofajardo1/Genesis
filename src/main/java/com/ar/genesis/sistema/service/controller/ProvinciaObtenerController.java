package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.input.IProvinciaObtenerInput;
import com.ar.genesis.sistema.service.dto.ProvinciaDTO;
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
public class ProvinciaObtenerController {
    @Inject
    IProvinciaObtenerInput miProvinciaObtenerInput;

    public ProvinciaObtenerController(IProvinciaObtenerInput miProvinciaObtenerInput) { this.miProvinciaObtenerInput = miProvinciaObtenerInput; }

    @GetMapping(value = "/provincia")
    public ResponseEntity<?> obtenerProvincias(){
        try{
            List<ProvinciaDTO> provinciasDTO = new ArrayList<>();
            miProvinciaObtenerInput.obtenerProvincias().forEach(unaProvincia -> provinciasDTO.add(new ProvinciaDTO(unaProvincia.getId(), unaProvincia.getNombre())));
            if (provinciasDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(provinciasDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
