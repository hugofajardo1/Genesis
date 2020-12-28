package com.ar.genesis.sistema.subrubro.service.controller;

import com.ar.genesis.sistema.subrubro.core.input.ISubRubroObtenerInput;
import com.ar.genesis.sistema.subrubro.service.dto.SubRubroDTO;
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
public class SubRubroObtenerController {
    @Inject
    ISubRubroObtenerInput miSubRubroObtenerInput;

    public SubRubroObtenerController(ISubRubroObtenerInput miSubRubroObtenerInput) { this.miSubRubroObtenerInput = miSubRubroObtenerInput; }

    @GetMapping(value = "/subrubro")
    public ResponseEntity<?> obtenerSubRubros(){
        try{
            ModelMapper modelMapper = new ModelMapper();
            List<SubRubroDTO> subRubrosDTO = new ArrayList<>();
            miSubRubroObtenerInput.obtenerSubRubros().forEach(unSubRubro -> subRubrosDTO.add(modelMapper.map(unSubRubro, SubRubroDTO.class)));
            if (subRubrosDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(subRubrosDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
