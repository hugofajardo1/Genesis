package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.input.IObtenerRubrosInput;
import com.ar.genesis.sistema.service.dto.RubroDTO;
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
public class ObtenerRubrosController {
    @Inject
    IObtenerRubrosInput miObtenerRubrosInput;

    public ObtenerRubrosController(IObtenerRubrosInput miObtenerRubrosInput) {
        this.miObtenerRubrosInput = miObtenerRubrosInput;
    }
    @GetMapping(value = "/Rubros")
    public ResponseEntity<?> obtenerRubros(){
        try{
            List<RubroDTO> rubrosDTO = new ArrayList<>();
            miObtenerRubrosInput.obtenerRubros().forEach(unRubro -> rubrosDTO.add(new RubroDTO(unRubro.getId(), unRubro.getNombre())));
            if (rubrosDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(rubrosDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
