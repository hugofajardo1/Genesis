package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Ficha;
import com.ar.genesis.sistema.core.exception.FichaNoExisteException;
import com.ar.genesis.sistema.core.input.IFichaObtenerPorIdInput;
import com.ar.genesis.sistema.service.dto.FichaDTO;
import com.ar.genesis.sistema.service.dto.LocalidadDTO;
import com.ar.genesis.sistema.service.dto.ProvinciaDTO;
import com.ar.genesis.sistema.service.dto.TipoIvaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class FichaObtenerPorIdController {
    @Inject
    IFichaObtenerPorIdInput miFichaObtenerPorIdInput;

    public FichaObtenerPorIdController(IFichaObtenerPorIdInput miFichaObtenerPorIdInput) { this.miFichaObtenerPorIdInput = miFichaObtenerPorIdInput; }

    @GetMapping(value = "/ficha/id/{id}")
    public ResponseEntity<?> obtenerFicha(@PathVariable Integer id){
        try{
            Ficha unaFicha = miFichaObtenerPorIdInput.obtenerFicha(id);
            FichaDTO unFichaDTO=null;
            if (unaFicha!=null){
                unFichaDTO = new FichaDTO(unaFicha.getId(), unaFicha.getNombre(), unaFicha.getDomicilio(), new LocalidadDTO(unaFicha.getLocalidad().getId(), unaFicha.getLocalidad().getNombre()), new ProvinciaDTO(unaFicha.getProvincia().getId(), unaFicha.getProvincia().getNombre()), unaFicha.getTelefono(), new TipoIvaDTO(unaFicha.getTipoIva().getId(), unaFicha.getTipoIva().getNombre()), unaFicha.getCuit(), unaFicha.getIbrutos(), unaFicha.getContacto());
            }
            return ResponseEntity.status(HttpStatus.OK).body(unFichaDTO);
        } catch (FichaNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}