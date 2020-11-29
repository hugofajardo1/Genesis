package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.input.IObtenerFichaInput;
import com.ar.genesis.sistema.service.dto.FichaDTO;
import com.ar.genesis.sistema.service.dto.TipoIvaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ObtenerFichasController {
    @Inject
    IObtenerFichaInput miObtenerFichaInput;

    public ObtenerFichasController(IObtenerFichaInput miObtenerFichaInput) { this.miObtenerFichaInput = miObtenerFichaInput; }

    @GetMapping(value = "/Fichas")
    public ResponseEntity<?> obtenerFichas(){
        try{
            List<FichaDTO> fichasDTO = new ArrayList<>();
            miObtenerFichaInput.obtenerFichas().forEach(unaFicha -> fichasDTO.add(new FichaDTO(unaFicha.getId(), unaFicha.getNombre(), unaFicha.getDomicilio(), unaFicha.getTelefono(), new TipoIvaDTO(1, "Responsable Inscripto"), "20255071336")));
            if (fichasDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(fichasDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
