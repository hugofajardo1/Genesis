package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.input.IFichaObtenerInput;
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
public class FichaObtenerController {
    @Inject
    IFichaObtenerInput miFichaObtenerInput;

    public FichaObtenerController(IFichaObtenerInput miFichaObtenerInput) { this.miFichaObtenerInput = miFichaObtenerInput; }

    @GetMapping(value = "/ficha")
    public ResponseEntity<?> obtenerFichas(){
        try{
            List<FichaDTO> fichasDTO = new ArrayList<>();
            miFichaObtenerInput.obtenerFichas().forEach(unaFicha -> fichasDTO.add(new FichaDTO(unaFicha.getId(), unaFicha.getNombre(), unaFicha.getDomicilio(), unaFicha.getTelefono(), new TipoIvaDTO(1, "Responsable Inscripto"), "20255071336")));
            if (fichasDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(fichasDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
