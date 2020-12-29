package com.ar.genesis.sistema.tipooperacion.service.controller;

import com.ar.genesis.sistema.tipooperacion.core.input.ITipoOperacionObtenerInput;
import com.ar.genesis.sistema.tipooperacion.service.dto.TipoOperacionDTO;
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
public class TipoOperacionObtenerController {
    @Inject
    ITipoOperacionObtenerInput miTipoOperacionObtenerInput;

    public TipoOperacionObtenerController(ITipoOperacionObtenerInput miTipoOperacionObtenerInput) { this.miTipoOperacionObtenerInput = miTipoOperacionObtenerInput; }

    @GetMapping(value = "/tipooperacion")
    public ResponseEntity<?> obtenerTipoOperaciones(){
        try{
            ModelMapper modelMapper = new ModelMapper();
            List<TipoOperacionDTO> tipoOperacionesDTO = new ArrayList<>();
            miTipoOperacionObtenerInput.obtenerTipoOperaciones().forEach(unTipoOperacion -> tipoOperacionesDTO.add(modelMapper.map(unTipoOperacion, TipoOperacionDTO.class)));
            if (tipoOperacionesDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(tipoOperacionesDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
