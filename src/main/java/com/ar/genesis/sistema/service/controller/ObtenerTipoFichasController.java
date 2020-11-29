package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.input.IObtenerTipoFichasInput;
import com.ar.genesis.sistema.service.dto.TipoFichaDTO;
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
public class ObtenerTipoFichasController {
    @Inject
    IObtenerTipoFichasInput miObtenerTipoFichasInput;

    public ObtenerTipoFichasController(IObtenerTipoFichasInput miObtenerTipoFichasInput) { this.miObtenerTipoFichasInput = miObtenerTipoFichasInput; }

    @GetMapping(value = "/TipoFichas")
    public ResponseEntity<?> obtenerTipoFichas(){
        try{
            List<TipoFichaDTO> tipoFichasDTO = new ArrayList<>();
            miObtenerTipoFichasInput.obtenerTipoFichas().forEach(unTipoFicha -> tipoFichasDTO.add(new TipoFichaDTO(unTipoFicha.getId(), unTipoFicha.getNombre())));
            if (tipoFichasDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(tipoFichasDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
