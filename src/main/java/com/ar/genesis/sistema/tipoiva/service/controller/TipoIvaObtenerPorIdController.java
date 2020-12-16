package com.ar.genesis.sistema.tipoiva.service.controller;

import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipoiva.core.exception.TipoIvaNoExisteException;
import com.ar.genesis.sistema.tipoiva.core.input.ITipoIvaObtenerPorIdInput;
import com.ar.genesis.sistema.tipoiva.service.dto.TipoIvaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TipoIvaObtenerPorIdController {
    @Inject
    ITipoIvaObtenerPorIdInput miTipoIvaObtenerPorIdInput;

    public TipoIvaObtenerPorIdController(ITipoIvaObtenerPorIdInput miTipoIvaObtenerPorIdInput) { this.miTipoIvaObtenerPorIdInput = miTipoIvaObtenerPorIdInput; }

    @GetMapping(value = "/tipoIva/id/{id}")
    public ResponseEntity<?> obtenerTipoIva(@PathVariable Integer id){
        try{
            TipoIva unTipoIva = miTipoIvaObtenerPorIdInput.obtenerTipoIva(id);
            TipoIvaDTO unTipoIvaDTO=null;
            if (unTipoIva!=null){
                unTipoIvaDTO = new TipoIvaDTO(unTipoIva.getId(), unTipoIva.getNombre());
            }
            return ResponseEntity.status(HttpStatus.OK).body(unTipoIvaDTO);
        } catch (TipoIvaNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}