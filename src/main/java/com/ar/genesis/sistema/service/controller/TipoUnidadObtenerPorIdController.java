package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.TipoUnidad;
import com.ar.genesis.sistema.core.exception.TipoUnidadNoExisteException;
import com.ar.genesis.sistema.core.input.ITipoUnidadObtenerPorIdInput;
import com.ar.genesis.sistema.service.dto.TipoUnidadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TipoUnidadObtenerPorIdController {
    @Inject
    ITipoUnidadObtenerPorIdInput miTipoUnidadObtenerPorIdInput;

    public TipoUnidadObtenerPorIdController(ITipoUnidadObtenerPorIdInput miTipoUnidadObtenerPorIdInput) { this.miTipoUnidadObtenerPorIdInput = miTipoUnidadObtenerPorIdInput; }

    @GetMapping(value = "/tipoUnidad/id/{id}")
    public ResponseEntity<?> obtenerTipoUnidad(@PathVariable Integer id){
        try{
            TipoUnidad unTipoUnidad = miTipoUnidadObtenerPorIdInput.obtenerTipoUnidad(id);
            TipoUnidadDTO unTipoUnidadDTO=null;
            if (unTipoUnidad!=null){
                unTipoUnidadDTO = new TipoUnidadDTO(unTipoUnidad.getId(), unTipoUnidad.getNombre());
            }
            return ResponseEntity.status(HttpStatus.OK).body(unTipoUnidadDTO);
        } catch (TipoUnidadNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}