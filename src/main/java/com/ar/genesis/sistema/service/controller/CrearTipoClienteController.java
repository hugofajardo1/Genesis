package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.TipoCliente;
import com.ar.genesis.sistema.core.exception.TipoClienteExisteException;
import com.ar.genesis.sistema.core.input.ICrearTipoClienteInput;
import com.ar.genesis.sistema.service.dto.TipoClienteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CrearTipoClienteController {
    @Inject
    ICrearTipoClienteInput iCrearTipoClienteInput;

    public CrearTipoClienteController(ICrearTipoClienteInput iCrearTipoClienteInput) {
        this.iCrearTipoClienteInput = iCrearTipoClienteInput;
    }

    @PostMapping(value = "/TipoCliente")
    public ResponseEntity<?> crearTipoCliente(@RequestBody TipoClienteDTO TipoClienteDTO){
        try{
            boolean resultado = this.iCrearTipoClienteInput.crearTipoCliente(TipoCliente.instancia(TipoClienteDTO.getId(), TipoClienteDTO.getNombre()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoClienteExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}