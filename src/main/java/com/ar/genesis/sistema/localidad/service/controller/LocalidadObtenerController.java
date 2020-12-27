package com.ar.genesis.sistema.localidad.service.controller;

import com.ar.genesis.sistema.localidad.core.input.ILocalidadObtenerInput;
import com.ar.genesis.sistema.localidad.service.dto.LocalidadDTO;
import org.modelmapper.ModelMapper;
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
    ILocalidadObtenerInput miLocalidadObtenerInput;

    public LocalidadObtenerController(ILocalidadObtenerInput miLocalidadObtenerInput) { this.miLocalidadObtenerInput = miLocalidadObtenerInput; }

    @GetMapping(value = "/localidad")
    public ResponseEntity<?> obtenerLocalidades(){
        try{
            List<LocalidadDTO> localidadesDTO = new ArrayList<>();
            ModelMapper modelMapper = new ModelMapper();
            miLocalidadObtenerInput.obtenerLocalidades().forEach(unaLocalidad -> localidadesDTO.add(modelMapper.map(unaLocalidad, LocalidadDTO.class)));
            if (localidadesDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(localidadesDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
