package com.ar.genesis.sistema.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MovimientoDTO {
    @JsonProperty("id")
    Integer id;
    @JsonProperty("tipomovimiento")
    TipoMovimientoDTO tipoMovimiento;
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

    public MovimientoDTO(Integer id, TipoMovimientoDTO tipoMovimiento, FichaDTO ficha, TipoIvaDTO tipoIva, String cuit, LocalDate fecha, LocalTime hora, Double montoNeto, Double montoTotal, Double saldo, List<MovimientoItemDTO> items) {
        this.setId(id);
        this.setTipoMovimiento(tipoMovimiento);
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

    public TipoMovimientoDTO getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimientoDTO tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
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
