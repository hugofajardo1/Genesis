package com.ar.genesis.sistema.movimiento.service.controller;

import com.ar.genesis.sistema.ficha.service.dto.FichaDTO;
import com.ar.genesis.sistema.localidad.service.dto.LocalidadDTO;
import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;
import com.ar.genesis.sistema.movimiento.core.exception.MovimientoNoExisteException;
import com.ar.genesis.sistema.movimiento.core.input.IMovimientoObtenerPorIdInput;
import com.ar.genesis.sistema.movimiento.service.dto.MovimientoDTO;
import com.ar.genesis.sistema.movimiento.service.dto.MovimientoItemDTO;
import com.ar.genesis.sistema.producto.service.dto.ProductoDTO;
import com.ar.genesis.sistema.provincia.service.dto.ProvinciaDTO;
import com.ar.genesis.sistema.puntoventa.service.dto.PuntoVentaDTO;
import com.ar.genesis.sistema.tipoiva.service.dto.TipoIvaDTO;
import com.ar.genesis.sistema.tipomovimiento.service.dto.TipoMovimientoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class MovimientoObtenerPorIdController {
    @Inject
    IMovimientoObtenerPorIdInput miMovimientoObtenerPorIdInput;

    public MovimientoObtenerPorIdController(IMovimientoObtenerPorIdInput miMovimientoObtenerPorIdInput) { this.miMovimientoObtenerPorIdInput = miMovimientoObtenerPorIdInput; }

    @GetMapping(value = "/movimiento/id/{id}")
    public ResponseEntity<?> obtenerMovimiento(@PathVariable Integer id){
        try{
            Movimiento unMovimiento = miMovimientoObtenerPorIdInput.obtenerMovimiento(id);
            MovimientoDTO unMovimientoDTO=null;
            if (unMovimiento!=null){
                /*PuntoVentaDTO unPuntoVenta = new PuntoVentaDTO(unMovimiento.getPuntoVenta().getId(), unMovimiento.getPuntoVenta().getNombre(), unMovimiento.getPuntoVenta().getSucursal(), unMovimiento.getPuntoVenta().getTipoFacturacion());
                TipoMovimientoDTO unTipoMovimiento = new TipoMovimientoDTO(unMovimiento.getTipoMovimiento().getId(), unMovimiento.getTipoMovimiento().getNombre(), unMovimiento.getTipoMovimiento().getImputacion());
                LocalidadDTO unaLocalidad = new LocalidadDTO(unMovimiento.getFicha().getLocalidad().getId(), unMovimiento.getFicha().getLocalidad().getNombre());
                ProvinciaDTO unaProvincia = new ProvinciaDTO(unMovimiento.getFicha().getProvincia().getId(), unMovimiento.getFicha().getProvincia().getNombre());
                TipoIvaDTO unTipoIva = new TipoIvaDTO(unMovimiento.getTipoIva().getId(), unMovimiento.getTipoIva().getNombre());
                FichaDTO unaFicha = new FichaDTO(unMovimiento.getFicha().getId(), unMovimiento.getFicha().getNombre(), unMovimiento.getFicha().getDomicilio(), unaLocalidad, unaProvincia, unMovimiento.getFicha().getTelefono(), unTipoIva, unMovimiento.getFicha().getCuit(), unMovimiento.getFicha().getIbrutos(), unMovimiento.getFicha().getContacto());
                List<MovimientoItemDTO> items = new ArrayList<>();
                unMovimiento.getItems().forEach(it -> items.add(new MovimientoItemDTO(it.getId(), new ProductoDTO())));
                unMovimientoDTO = new MovimientoDTO(unMovimiento.getId(), unPuntoVenta, unTipoMovimiento, unaFicha, unTipoIva, unMovimiento.getCuit(), unMovimiento.getFecha(), unMovimiento.getHora(), unMovimiento.getMontoNeto(), unMovimiento.getMontoTotal(), unMovimiento.getSaldo(), unMovimiento.getItems());
                 */
                ModelMapper modelMapper = new ModelMapper();
                unMovimientoDTO = modelMapper.map(unMovimiento, MovimientoDTO.class);
            }
            return ResponseEntity.status(HttpStatus.OK).body(unMovimientoDTO);
        } catch (MovimientoNoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.toString());
        }
    }
}