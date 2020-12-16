package com.ar.genesis.sistema.rubro.service.controller;

import com.ar.genesis.sistema.rubro.core.domain.Rubro;
import com.ar.genesis.sistema.rubro.core.exception.RubroNoExisteException;
import com.ar.genesis.sistema.rubro.core.input.IRubroObtenerPorIdInput;
import com.ar.genesis.sistema.rubro.service.dto.RubroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class RubroObtenerPorIdController {
    @Inject
    IRubroObtenerPorIdInput miRubroObtenerPorIdInput;

    public RubroObtenerPorIdController(IRubroObtenerPorIdInput miRubroObtenerPorIdInput) { this.miRubroObtenerPorIdInput = miRubroObtenerPorIdInput; }

    @GetMapping(value = "/rubro/id/{id}")
    public ResponseEntity<?> obtenerRubro(@PathVariable Integer id){
        try{
            Rubro unRubro = miRubroObtenerPorIdInput.obtenerRubro(id);
            RubroDTO unRubroDTO=null;
            if (unRubro!=null){
                unRubroDTO = new RubroDTO(unRubro.getId(), unRubro.getNombre());
            }
            return ResponseEntity.status(HttpStatus.OK).body(unRubroDTO);
        } catch (RubroNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}