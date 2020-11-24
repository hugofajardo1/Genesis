package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.input.IObtenerUbicacionesInput;
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
public class ObtenerUbicacionesController {
    @Inject
    IObtenerUbicacionesInput iObtenerUbicacionesInput;

    public ObtenerUbicacionesController(IObtenerUbicacionesInput iObtenerUbicacionesInput) {
        this.iObtenerUbicacionesInput = iObtenerUbicacionesInput;
    }
    @GetMapping(value = "/Ubicaciones")
    public ResponseEntity<?> obtenerUbicaciones(){
        try{
            List<UbicacionDTO> UbicacionesDTO = new ArrayList<>();
            iObtenerUbicacionesInput.obtenerUbicaciones().forEach(Ubicacion -> UbicacionesDTO.add(new UbicacionDTO(Ubicacion.getId(), Ubicacion.getNombre())));
            if (UbicacionesDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(UbicacionesDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
