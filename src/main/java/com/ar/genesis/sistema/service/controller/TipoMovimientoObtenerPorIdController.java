package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.core.exception.TipoMovimientoNoExisteException;
import com.ar.genesis.sistema.core.input.ITipoMovimientoObtenerPorIdInput;
import com.ar.genesis.sistema.service.dto.TipoMovimientoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TipoMovimientoObtenerPorIdController {
    @Inject
    ITipoMovimientoObtenerPorIdInput miTipoMovimientoObtenerPorIdInput;

    public TipoMovimientoObtenerPorIdController(ITipoMovimientoObtenerPorIdInput miTipoMovimientoObtenerPorIdInput) { this.miTipoMovimientoObtenerPorIdInput = miTipoMovimientoObtenerPorIdInput; }

    @GetMapping(value = "/tipoMovimiento/id/{id}")
    public ResponseEntity<?> obtenerTipoMovimiento(@PathVariable Integer id){
        try{
            TipoMovimiento unTipoMovimiento = miTipoMovimientoObtenerPorIdInput.obtenerTipoMovimiento(id);
            TipoMovimientoDTO unTipoMovimientoDTO=null;
            if (unTipoMovimiento!=null){
                unTipoMovimientoDTO = new TipoMovimientoDTO(unTipoMovimiento.getId(), unTipoMovimiento.getNombre());
            }
            return ResponseEntity.status(HttpStatus.OK).body(unTipoMovimientoDTO);
        } catch (TipoMovimientoNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}