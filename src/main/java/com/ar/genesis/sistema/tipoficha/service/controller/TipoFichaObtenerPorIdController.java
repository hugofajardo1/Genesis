package com.ar.genesis.sistema.tipoficha.service.controller;

import com.ar.genesis.sistema.tipoficha.core.domain.TipoFicha;
import com.ar.genesis.sistema.tipoficha.core.exception.TipoFichaNoExisteException;
import com.ar.genesis.sistema.tipoficha.core.input.ITipoFichaObtenerPorIdInput;
import com.ar.genesis.sistema.tipoficha.service.dto.TipoFichaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TipoFichaObtenerPorIdController {
    @Inject
    ITipoFichaObtenerPorIdInput miTipoFichaObtenerPorIdInput;

    public TipoFichaObtenerPorIdController(ITipoFichaObtenerPorIdInput miTipoFichaObtenerPorIdInput) { this.miTipoFichaObtenerPorIdInput = miTipoFichaObtenerPorIdInput; }

    @GetMapping(value = "/tipoFicha/id/{id}")
    public ResponseEntity<?> obtenerTipoFicha(@PathVariable Integer id){
        try{
            TipoFicha unTipoFicha = miTipoFichaObtenerPorIdInput.obtenerTipoFicha(id);
            TipoFichaDTO unTipoFichaDTO=null;
            if (unTipoFicha!=null){
                unTipoFichaDTO = new TipoFichaDTO(unTipoFicha.getId(), unTipoFicha.getNombre());
            }
            return ResponseEntity.status(HttpStatus.OK).body(unTipoFichaDTO);
        } catch (TipoFichaNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}