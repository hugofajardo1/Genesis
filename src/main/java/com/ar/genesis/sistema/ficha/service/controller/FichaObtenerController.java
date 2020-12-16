package com.ar.genesis.sistema.ficha.service.controller;

import com.ar.genesis.sistema.ficha.core.input.IFichaObtenerInput;
import com.ar.genesis.sistema.ficha.service.dto.FichaDTO;
import com.ar.genesis.sistema.localidad.service.dto.LocalidadDTO;
import com.ar.genesis.sistema.provincia.service.dto.ProvinciaDTO;
import com.ar.genesis.sistema.tipoiva.service.dto.TipoIvaDTO;
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
            miFichaObtenerInput.obtenerFichas().forEach(unaFicha -> fichasDTO.add(new FichaDTO(unaFicha.getId(), unaFicha.getNombre(), unaFicha.getDomicilio(), new LocalidadDTO(unaFicha.getLocalidad().getId(), unaFicha.getLocalidad().getNombre()), new ProvinciaDTO(unaFicha.getProvincia().getId(), unaFicha.getProvincia().getNombre()), unaFicha.getTelefono(), new TipoIvaDTO(unaFicha.getTipoIva().getId(), unaFicha.getTipoIva().getNombre()), unaFicha.getCuit(), unaFicha.getIbrutos(), unaFicha.getContacto())));
            if (fichasDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(fichasDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
