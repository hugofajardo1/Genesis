package com.ar.genesis.sistema.tipoiva.service.controller;

import com.ar.genesis.sistema.tipoiva.core.input.ITipoIvaObtenerInput;
import com.ar.genesis.sistema.tipoiva.service.dto.TipoIvaDTO;
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
public class TipoIvaObtenerController {
    @Inject
    ITipoIvaObtenerInput miTipoIvaObtenerInput;

    public TipoIvaObtenerController(ITipoIvaObtenerInput miTipoIvaObtenerInput) { this.miTipoIvaObtenerInput = miTipoIvaObtenerInput; }

    @GetMapping(value = "/tipoiva")
    public ResponseEntity<?> obtenerTipoIvas(){
        try{
            ModelMapper modelMapper = new ModelMapper();
            List<TipoIvaDTO> tipoIvasDTO = new ArrayList<>();
            miTipoIvaObtenerInput.obtenerTipoIvas().forEach(unTipoIva -> tipoIvasDTO.add(modelMapper.map(unTipoIva, TipoIvaDTO.class)));
            if (tipoIvasDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(tipoIvasDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
