package com.ar.genesis.sistema.movimiento.service.dto;

import com.ar.genesis.sistema.ficha.service.dto.FichaDTO;
import com.ar.genesis.sistema.puntoventa.service.dto.PuntoVentaDTO;
import com.ar.genesis.sistema.sucursal.service.dto.SucursalDTO;
import com.ar.genesis.sistema.tipoiva.service.dto.TipoIvaDTO;
import com.ar.genesis.sistema.tipomovimiento.service.dto.TipoMovimientoDTO;
import com.ar.genesis.sistema.tipooperacion.service.dto.TipoOperacionDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MovimientoDTO {
    @JsonProperty("id")
    Integer id;
    @JsonProperty("sucursal")
    SucursalDTO sucursal;
    @JsonProperty("puntoventa")
    PuntoVentaDTO puntoVenta;
    @JsonProperty("tipooperacion")
    TipoOperacionDTO tipoOperacion;
    @JsonProperty("tipomovimiento")
    TipoMovimientoDTO tipoMovimiento;
    @JsonProperty("numero")
    Integer numero;
    @JsonProperty("ficha")
    FichaDTO ficha;
    @JsonProperty("tipoiva")
    TipoIvaDTO tipoIva;
    @JsonProperty("cuit")
    String cuit;
    @JsonProperty("fecha")
    LocalDate fecha;
    @JsonProperty("hora")
    LocalTime hora;
    @JsonProperty("montoneto")
    Double montoNeto;
    @JsonProperty("montototal")
    Double montoTotal;
    @JsonProperty("saldo")
    Double saldo;
    @JsonProperty("items")
    List<MovimientoItemDTO> items;

    public MovimientoDTO(){

    }

    public MovimientoDTO(Integer id, PuntoVentaDTO puntoVenta, TipoOperacionDTO tipoOperacion, TipoMovimientoDTO tipoMovimiento, Integer numero, FichaDTO ficha, TipoIvaDTO tipoIva, String cuit, LocalDate fecha, LocalTime hora, Double montoNeto, Double montoTotal, Double saldo, List<MovimientoItemDTO> items) {
        this.setId(id);
        this.setSucursal(puntoVenta.getSucursal());
        this.setPuntoVenta(puntoVenta);
        this.setTipoOperacion(tipoOperacion);
        this.setTipoMovimiento(tipoMovimiento);
        this.setNumero(numero);
        this.setFicha(ficha);
        this.setTipoIva(tipoIva);
        this.setCuit(cuit);
        this.setFecha(fecha);
        this.setHora(hora);
        this.setMontoNeto(montoNeto);
        this.setMontoTotal(montoTotal);
        this.setSaldo(saldo);
        this.setItems(items);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }

    public PuntoVentaDTO getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(PuntoVentaDTO puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public TipoOperacionDTO getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacionDTO tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public TipoMovimientoDTO getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimientoDTO tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public FichaDTO getFicha() {
        return ficha;
    }

    public void setFicha(FichaDTO ficha) {
        this.ficha = ficha;
    }

    public TipoIvaDTO getTipoIva() {
        return tipoIva;
    }

    public void setTipoIva(TipoIvaDTO tipoIva) {
        this.tipoIva = tipoIva;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Double getMontoNeto() {
        return montoNeto;
    }

    public void setMontoNeto(Double montoNeto) {
        this.montoNeto = montoNeto;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<MovimientoItemDTO> getItems() {
        return items;
    }

    public void setItems(List<MovimientoItemDTO> items) {
        this.items = items;
    }
}
