package com.ar.genesis.sistema.tipoficha.service.controller;

import com.ar.genesis.sistema.tipoficha.core.input.ITipoFichaObtenerInput;
import com.ar.genesis.sistema.tipoficha.service.dto.TipoFichaDTO;
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
public class TipoFichaObtenerController {
    @Inject
    ITipoFichaObtenerInput miTipoFichaObtenerInput;

    public TipoFichaObtenerController(ITipoFichaObtenerInput miTipoFichaObtenerInput) { this.miTipoFichaObtenerInput = miTipoFichaObtenerInput; }

    @GetMapping(value = "/tipoficha")
    public ResponseEntity<?> obtenerTipoFichas(){
        try{
            ModelMapper modelMapper = new ModelMapper();
            List<TipoFichaDTO> tipoFichasDTO = new ArrayList<>();
            miTipoFichaObtenerInput.obtenerTipoFichas().forEach(unTipoFicha -> tipoFichasDTO.add(modelMapper.map(unTipoFicha, TipoFichaDTO.class)));
            if (tipoFichasDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(tipoFichasDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
