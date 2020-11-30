package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.input.IUbicacionObtenerInput;
import com.ar.genesis.sistema.service.dto.UbicacionDTO;
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
public class UbicacionObtenerController {
    @Inject
    IUbicacionObtenerInput miUbicacionObtenerInput;

    public UbicacionObtenerController(IUbicacionObtenerInput miUbicacionObtenerInput) { this.miUbicacionObtenerInput = miUbicacionObtenerInput; }

    @GetMapping(value = "/ubicacion")
    public ResponseEntity<?> obtenerUbicaciones(){
        try{
            List<UbicacionDTO> ubicacionesDTO = new ArrayList<>();
            miUbicacionObtenerInput.obtenerUbicaciones().forEach(unaUbicacion -> ubicacionesDTO.add(new UbicacionDTO(unaUbicacion.getId(), unaUbicacion.getNombre())));
            if (ubicacionesDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(ubicacionesDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
