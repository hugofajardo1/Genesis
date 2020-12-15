package com.ar.genesis.sistema.service.controller;

import com.ar.genesis.sistema.core.domain.*;
import com.ar.genesis.sistema.core.exception.MovimientoExisteException;
import com.ar.genesis.sistema.core.exception.MovimientoIncompletoException;
import com.ar.genesis.sistema.core.input.IMovimientoCrearInput;
import com.ar.genesis.sistema.service.dto.MovimientoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class MovimientoCrearController {
    @Inject
    IMovimientoCrearInput miMovimientoCrearInput;

    public MovimientoCrearController(IMovimientoCrearInput miMovimientoCrearInput) {
        this.miMovimientoCrearInput = miMovimientoCrearInput;
    }

    @PostMapping(value = "/movimiento")
    public ResponseEntity<?> crearMovimiento(@RequestBody MovimientoDTO unMovimientoDTO){
        try{
            TipoIva unTipoIva = TipoIva.instancia(unMovimientoDTO.getFicha().getTipoIva().getId(), unMovimientoDTO.getFicha().getTipoIva().getNombre());
            TipoMovimiento unTipoMovimiento = TipoMovimiento.instancia(unMovimientoDTO.getTipoMovimiento().getId(), unMovimientoDTO.getTipoMovimiento().getNombre());
            Localidad unaLocalidad = Localidad.instancia(unMovimientoDTO.getFicha().getLocalidad().getId(), unMovimientoDTO.getFicha().getLocalidad().getNombre());
            Provincia unaProvincia = Provincia.instancia(unMovimientoDTO.getFicha().getProvincia().getId(), unMovimientoDTO.getFicha().getProvincia().getNombre());
            Ficha unaFicha = Ficha.instancia(unMovimientoDTO.getFicha().getId(), unMovimientoDTO.getFicha().getNombre(), unMovimientoDTO.getFicha().getDomicilio(), unaLocalidad, unaProvincia, unMovimientoDTO.getFicha().getTelefono(), unTipoIva, unMovimientoDTO.getFicha().getCuit(), unMovimientoDTO.getFicha().getIbrutos(), unMovimientoDTO.getFicha().getContacto());

            boolean resultado = this.miMovimientoCrearInput.crearMovimiento(Movimiento.instancia(unMovimientoDTO.getId(), unTipoMovimiento, unaFicha, unTipoIva, unaFicha.getCuit(), unMovimientoDTO.getFecha(), unMovimientoDTO.getHora(), unMovimientoDTO.getMontoNeto(), unMovimientoDTO.getMontoTotal(), unMovimientoDTO.getSaldo()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (MovimientoExisteException | MovimientoIncompletoException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}