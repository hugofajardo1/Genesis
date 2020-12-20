package com.ar.genesis.sistema.movimiento.service.controller;

import com.ar.genesis.sistema.movimiento.core.exception.MovimientoExisteException;
import com.ar.genesis.sistema.movimiento.core.exception.MovimientoIncompletoException;
import com.ar.genesis.sistema.movimiento.core.input.IMovimientoCrearInput;
import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.localidad.core.domain.Localidad;
import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import com.ar.genesis.sistema.provincia.core.domain.Provincia;
import com.ar.genesis.sistema.movimiento.service.dto.MovimientoDTO;
import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
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
            PuntoVenta unPuntoVenta = PuntoVenta.instancia(unMovimientoDTO.getPuntoVenta().getId(), unMovimientoDTO.getPuntoVenta().getNombre(), Sucursal.instancia(unMovimientoDTO.getSucursal().getId(), unMovimientoDTO.getSucursal().getNombre()), 5);
            TipoIva unTipoIva = TipoIva.instancia(unMovimientoDTO.getFicha().getTipoIva().getId(), unMovimientoDTO.getFicha().getTipoIva().getNombre());
            TipoMovimiento unTipoMovimiento = TipoMovimiento.instancia(unMovimientoDTO.getTipoMovimiento().getId(), unMovimientoDTO.getTipoMovimiento().getNombre());
            Localidad unaLocalidad = Localidad.instancia(unMovimientoDTO.getFicha().getLocalidad().getId(), unMovimientoDTO.getFicha().getLocalidad().getNombre());
            Provincia unaProvincia = Provincia.instancia(unMovimientoDTO.getFicha().getProvincia().getId(), unMovimientoDTO.getFicha().getProvincia().getNombre());
            Ficha unaFicha = Ficha.instancia(unMovimientoDTO.getFicha().getId(), unMovimientoDTO.getFicha().getNombre(), unMovimientoDTO.getFicha().getDomicilio(), unaLocalidad, unaProvincia, unMovimientoDTO.getFicha().getTelefono(), unTipoIva, unMovimientoDTO.getFicha().getCuit(), unMovimientoDTO.getFicha().getIbrutos(), unMovimientoDTO.getFicha().getContacto());

            boolean resultado = this.miMovimientoCrearInput.crearMovimiento(Movimiento.instancia(unMovimientoDTO.getId(), unPuntoVenta, unTipoMovimiento, unaFicha, unTipoIva, unaFicha.getCuit(), unMovimientoDTO.getFecha(), unMovimientoDTO.getHora(), unMovimientoDTO.getMontoNeto(), unMovimientoDTO.getMontoTotal(), unMovimientoDTO.getSaldo()));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (MovimientoExisteException | MovimientoIncompletoException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}