package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.input.ISubRubroObtenerInput;
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
public class SubRubroObtenerController {
    @Inject
    ISubRubroObtenerInput miSubRubroObtenerInput;

    public SubRubroObtenerController(ISubRubroObtenerInput miSubRubroObtenerInput) { this.miSubRubroObtenerInput = miSubRubroObtenerInput; }

    @GetMapping(value = "/subrubro")
    public ResponseEntity<?> obtenerSubRubros(){
        try{
            List<SubRubroDTO> subRubrosDTO = new ArrayList<>();
            miSubRubroObtenerInput.obtenerSubRubros().forEach(unSubRubro -> subRubrosDTO.add(new SubRubroDTO(unSubRubro.getId(), unSubRubro.getNombre())));
            if (subRubrosDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(subRubrosDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
