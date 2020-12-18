package com.ar.genesis.sistema.puntoventa.service.dto;

import com.ar.genesis.sistema.sucursal.service.dto.SucursalDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PuntoVentaDTO {

    @JsonProperty("id")
    Integer id;
    @JsonProperty("nombre")
    String nombre;
    @JsonProperty("sucursal")
    SucursalDTO sucursal;
    @JsonProperty("tipofacturacion")
    Integer tipofacturacion;

    public PuntoVentaDTO(Integer id, String nombre, SucursalDTO sucursal, Integer tipoFacturacion) {
        this.setId(id);
        this.setNombre(nombre);
        this.setSucursal(sucursal);
        this.setTipofacturacion(tipoFacturacion);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getTipofacturacion() {
        return tipofacturacion;
    }

    public void setTipofacturacion(Integer tipofacturacion) {
        this.tipofacturacion = tipofacturacion;
    }
}