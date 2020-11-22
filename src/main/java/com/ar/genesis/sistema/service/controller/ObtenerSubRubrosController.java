package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.input.IObtenerSubRubrosInput;
import com.ar.genesis.sistema.service.dto.SubRubroDTO;
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
public class ObtenerSubRubrosController {
    @Inject
    IObtenerSubRubrosInput iObtenerSubRubrosInput;

    public ObtenerSubRubrosController(IObtenerSubRubrosInput iObtenerSubRubrosInput) {
        this.iObtenerSubRubrosInput = iObtenerSubRubrosInput;
    }
    @GetMapping(value = "/SubRubros")
    public ResponseEntity<?> obtenerSubRubros(){
        try{
            List<SubRubroDTO> SubRubrosDTO = new ArrayList<>();
            iObtenerSubRubrosInput.obtenerSubRubros().forEach(SubRubro -> SubRubrosDTO.add(new SubRubroDTO(SubRubro.getId(), SubRubro.getNombre())));
            if (SubRubrosDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(SubRubrosDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
