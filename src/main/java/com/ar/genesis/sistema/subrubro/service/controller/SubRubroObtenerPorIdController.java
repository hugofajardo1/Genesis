package com.ar.genesis.sistema.subrubro.service.controller;

import com.ar.genesis.sistema.subrubro.core.domain.SubRubro;
import com.ar.genesis.sistema.subrubro.core.exception.SubRubroNoExisteException;
import com.ar.genesis.sistema.subrubro.core.input.ISubRubroObtenerPorIdInput;
import com.ar.genesis.sistema.subrubro.service.dto.SubRubroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class SubRubroObtenerPorIdController {
    @Inject
    ISubRubroObtenerPorIdInput miSubRubroObtenerPorIdInput;

    public SubRubroObtenerPorIdController(ISubRubroObtenerPorIdInput miSubRubroObtenerPorIdInput) { this.miSubRubroObtenerPorIdInput = miSubRubroObtenerPorIdInput; }

    @GetMapping(value = "/subRubro/id/{id}")
    public ResponseEntity<?> obtenerSubRubro(@PathVariable Integer id){
        try{
            SubRubro unSubRubro = miSubRubroObtenerPorIdInput.obtenerSubRubro(id);
            SubRubroDTO unSubRubroDTO=null;
            if (unSubRubro!=null){
                unSubRubroDTO = new SubRubroDTO(unSubRubro.getId(), unSubRubro.getNombre());
            }
            return ResponseEntity.status(HttpStatus.OK).body(unSubRubroDTO);
        } catch (SubRubroNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}