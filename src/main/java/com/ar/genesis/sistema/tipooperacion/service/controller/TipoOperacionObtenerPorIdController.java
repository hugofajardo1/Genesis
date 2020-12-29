package com.ar.genesis.sistema.tipooperacion.service.controller;

import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;
import com.ar.genesis.sistema.tipooperacion.core.exception.TipoOperacionNoExisteException;
import com.ar.genesis.sistema.tipooperacion.core.input.ITipoOperacionObtenerPorIdInput;
import com.ar.genesis.sistema.tipooperacion.service.dto.TipoOperacionDTO;
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
public class TipoOperacionObtenerPorIdController {
    @Inject
    ITipoOperacionObtenerPorIdInput miTipoOperacionObtenerPorIdInput;

    public TipoOperacionObtenerPorIdController(ITipoOperacionObtenerPorIdInput miTipoOperacionObtenerPorIdInput) { this.miTipoOperacionObtenerPorIdInput = miTipoOperacionObtenerPorIdInput; }

    @GetMapping(value = "/tipoOperacion/id/{id}")
    public ResponseEntity<?> obtenerTipoOperacion(@PathVariable Integer id){
        try{
            TipoOperacion unTipoOperacion = miTipoOperacionObtenerPorIdInput.obtenerTipoOperacion(id);
            TipoOperacionDTO unTipoOperacionDTO=null;
            if (unTipoOperacion!=null){
                ModelMapper modelMapper = new ModelMapper();
                unTipoOperacionDTO = modelMapper.map(unTipoOperacion, TipoOperacionDTO.class);
            }
            return ResponseEntity.status(HttpStatus.OK).body(unTipoOperacionDTO);
        } catch (TipoOperacionNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}