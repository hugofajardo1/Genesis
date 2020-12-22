package com.ar.genesis.sistema.ficha.service.controller;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.ficha.core.exception.FichaExisteException;
import com.ar.genesis.sistema.ficha.core.input.IFichaModificarInput;
import com.ar.genesis.sistema.ficha.service.dto.FichaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class FichaModificarController {

    @Inject
    IFichaModificarInput miFichaModificarInput;

    public FichaModificarController(IFichaModificarInput miFichaModificarInput) { this.miFichaModificarInput = miFichaModificarInput; }

    @PutMapping(value = "/ficha")
    public ResponseEntity<?> modificarFicha(@RequestBody FichaDTO unaFichaDTO){
        try{
            boolean resultado = this.miFichaModificarInput.modificarFicha(Ficha.instancia(unaFichaDTO.getId(), unaFichaDTO.getNombre(), unaFichaDTO.getDomicilio(), Localidad.instancia(unaFichaDTO.getLocalidad().getId(), unaFichaDTO.getLocalidad().getNombre()), Provincia.instancia(unaFichaDTO.getProvincia().getId(), unaFichaDTO.getProvincia().getNombre()), unaFichaDTO.getTelefono(), TipoIva.instancia(unaFichaDTO.getTipoIva().getId(), unaFichaDTO.getTipoIva().getNombre()), unaFichaDTO.getCuit(), unaFichaDTO.getIbrutos(), unaFichaDTO.getContacto()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (FichaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}