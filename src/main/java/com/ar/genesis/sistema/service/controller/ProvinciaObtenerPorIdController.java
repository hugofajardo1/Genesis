package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Provincia;
import com.ar.genesis.sistema.core.exception.ProvinciaNoExisteException;
import com.ar.genesis.sistema.core.input.IProvinciaObtenerPorIdInput;
import com.ar.genesis.sistema.service.dto.ProvinciaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProvinciaObtenerPorIdController {
    @Inject
    IProvinciaObtenerPorIdInput miProvinciaObtenerPorIdInput;

    public ProvinciaObtenerPorIdController(IProvinciaObtenerPorIdInput miProvinciaObtenerPorIdInput) { this.miProvinciaObtenerPorIdInput = miProvinciaObtenerPorIdInput; }

    @GetMapping(value = "/provincia/id/{id}")
    public ResponseEntity<?> obtenerProvincia(@PathVariable Integer id){
        try{
            Provincia unaProvincia = miProvinciaObtenerPorIdInput.obtenerProvincia(id);
            ProvinciaDTO unaProvinciaDTO=null;
            if (unaProvincia!=null){
                unaProvinciaDTO = new ProvinciaDTO(unaProvincia.getId(), unaProvincia.getNombre());
            }
            return ResponseEntity.status(HttpStatus.OK).body(unaProvinciaDTO);
        } catch (ProvinciaNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}