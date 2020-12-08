package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.Localidad;
import com.ar.genesis.sistema.core.exception.LocalidadNoExisteException;
import com.ar.genesis.sistema.core.input.ILocalidadObtenerPorIdInput;
import com.ar.genesis.sistema.service.dto.LocalidadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class LocalidadObtenerPorIdController {
    @Inject
    ILocalidadObtenerPorIdInput miLocalidadObtenerPorIdInput;

    public LocalidadObtenerPorIdController(ILocalidadObtenerPorIdInput miLocalidadObtenerPorIdInput) { this.miLocalidadObtenerPorIdInput = miLocalidadObtenerPorIdInput; }

    @GetMapping(value = "/localidad/id/{id}")
    public ResponseEntity<?> obtenerLocalidad(@PathVariable Integer id){
        try{
            Localidad unaLocalidad = miLocalidadObtenerPorIdInput.obtenerLocalidad(id);
            LocalidadDTO unLocalidadDTO=null;
            if (unaLocalidad!=null){
                unLocalidadDTO = new LocalidadDTO(unaLocalidad.getId(), unaLocalidad.getNombre());
            }
            return ResponseEntity.status(HttpStatus.OK).body(unLocalidadDTO);
        } catch (LocalidadNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}