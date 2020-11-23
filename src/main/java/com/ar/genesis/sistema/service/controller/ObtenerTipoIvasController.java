package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.input.IObtenerTipoIvasInput;
import com.ar.genesis.sistema.service.dto.TipoIvaDTO;
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
public class ObtenerTipoIvasController {
    @Inject
    IObtenerTipoIvasInput iObtenerTipoIvasInput;

    public ObtenerTipoIvasController(IObtenerTipoIvasInput iObtenerTipoIvasInput) {
        this.iObtenerTipoIvasInput = iObtenerTipoIvasInput;
    }
    @GetMapping(value = "/TipoIvas")
    public ResponseEntity<?> obtenerTipoIvas(){
        try{
            List<TipoIvaDTO> tipoIvasDTO = new ArrayList<>();
            iObtenerTipoIvasInput.obtenerTipoIvas().forEach(TipoIva -> tipoIvasDTO.add(new TipoIvaDTO(TipoIva.getId(), TipoIva.getNombre())));
            if (tipoIvasDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(tipoIvasDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
