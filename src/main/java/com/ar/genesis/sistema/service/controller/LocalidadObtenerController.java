package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.input.IObtenerLocalidadesInput;
import com.ar.genesis.sistema.service.dto.LocalidadDTO;
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
public class LocalidadObtenerController {
    @Inject
    IObtenerLocalidadesInput miObtenerLocalidadesInput;

    public LocalidadObtenerController(IObtenerLocalidadesInput miObtenerLocalidadesInput) { this.miObtenerLocalidadesInput = miObtenerLocalidadesInput; }

    @GetMapping(value = "/Localidades")
    public ResponseEntity<?> obtenerLocalidades(){
        try{
            List<LocalidadDTO> localidadesDTO = new ArrayList<>();
            miObtenerLocalidadesInput.obtenerLocalidades().forEach(unaLocalidad -> localidadesDTO.add(new LocalidadDTO(unaLocalidad.getId(), unaLocalidad.getNombre())));
            if (localidadesDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(localidadesDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
