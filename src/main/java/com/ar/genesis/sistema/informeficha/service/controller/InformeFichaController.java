package com.ar.genesis.sistema.informeficha.service.controller;

import com.ar.genesis.sistema.ficha.core.exception.FichaNoExisteException;
import com.ar.genesis.sistema.informeficha.core.domain.InformeFicha;
import com.ar.genesis.sistema.informeficha.core.input.IInformeFichaInput;
import com.ar.genesis.sistema.informeficha.service.dto.InformeFichaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.time.LocalDate;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class InformeFichaController {
    @Inject
    IInformeFichaInput miInformeFichaInput;

    public InformeFichaController(IInformeFichaInput miInformeFichaInput) { this.miInformeFichaInput = miInformeFichaInput; }

    @GetMapping(value = "/ficha/id/{id}/desde/{desde}/hasta/{hasta}")
    public ResponseEntity<?> obtenerInformeFicha(@PathVariable Integer id, @PathVariable LocalDate desde, @PathVariable LocalDate hasta){
        try{
            InformeFicha informeFicha = miInformeFichaInput.obtenerInformeFicha(id, desde, hasta);
            InformeFichaDTO informeFichaDTO=null;
            if (informeFicha!=null){
                ModelMapper modelMapper = new ModelMapper();
                informeFichaDTO = modelMapper.map(informeFicha, InformeFichaDTO.class);
            }
            return ResponseEntity.status(HttpStatus.OK).body(informeFichaDTO);
        } catch (FichaNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}