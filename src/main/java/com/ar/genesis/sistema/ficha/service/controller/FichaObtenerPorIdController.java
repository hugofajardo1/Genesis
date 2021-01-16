package com.ar.genesis.sistema.ficha.service.controller;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.ficha.core.exception.FichaNoExisteException;
import com.ar.genesis.sistema.ficha.core.input.IFichaObtenerPorIdInput;
import com.ar.genesis.sistema.ficha.service.dto.FichaDTO;
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
public class FichaObtenerPorIdController {
    @Inject
    IFichaObtenerPorIdInput miInformeFichaInput;

    public FichaObtenerPorIdController(IFichaObtenerPorIdInput miInformeFichaInput) { this.miInformeFichaInput = miInformeFichaInput; }

    @GetMapping(value = "/ficha/id/{id}")
    public ResponseEntity<?> obtenerFicha(@PathVariable Integer id){
        try{
            Ficha unaFicha = miInformeFichaInput.obtenerFicha(id);
            FichaDTO unaFichaDTO=null;
            if (unaFicha!=null){
                ModelMapper modelMapper = new ModelMapper();
                unaFichaDTO = modelMapper.map(unaFicha, FichaDTO.class);
            }
            return ResponseEntity.status(HttpStatus.OK).body(unaFichaDTO);
        } catch (FichaNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}