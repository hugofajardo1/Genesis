package com.ar.genesis.sistema.ubicacion.service.controller;

import com.ar.genesis.sistema.ubicacion.core.domain.Ubicacion;
import com.ar.genesis.sistema.ubicacion.core.exception.UbicacionNoExisteException;
import com.ar.genesis.sistema.ubicacion.core.input.IUbicacionObtenerPorIdInput;
import com.ar.genesis.sistema.ubicacion.service.dto.UbicacionDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UbicacionObtenerPorIdController {
    @Inject
    IUbicacionObtenerPorIdInput miUbicacionObtenerPorIdInput;

    public UbicacionObtenerPorIdController(IUbicacionObtenerPorIdInput miUbicacionObtenerPorIdInput) { this.miUbicacionObtenerPorIdInput = miUbicacionObtenerPorIdInput; }

    @GetMapping(value = "/ubicacion/id/{id}")
    public ResponseEntity<?> obtenerUbicacion(@PathVariable Integer id){
        try{
            Ubicacion unaUbicacion = miUbicacionObtenerPorIdInput.obtenerUbicacion(id);
            UbicacionDTO unaUbicacionDTO=null;
            if (unaUbicacion!=null){
                ModelMapper modelMapper = new ModelMapper();
                unaUbicacionDTO = modelMapper.map(unaUbicacion, UbicacionDTO.class);
            }
            return ResponseEntity.status(HttpStatus.OK).body(unaUbicacionDTO);
        } catch (UbicacionNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}