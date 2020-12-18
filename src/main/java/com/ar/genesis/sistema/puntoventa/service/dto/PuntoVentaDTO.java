package com.ar.genesis.sistema.puntoventa.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PuntoVentaDTO {

    @JsonProperty("id")
    Integer id;
    @JsonProperty("nombre")
    String nombre;
    @JsonProperty("tipofacturacion")
    Integer tipofacturacion;

    public PuntoVentaDTO(Integer id, String nombre, Integer tipoFacturacion) {
        this.setId(id);
        this.setNombre(nombre);
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

    public Integer getTipofacturacion() {
        return tipofacturacion;
    }

    public void setTipofacturacion(Integer tipofacturacion) {
        this.tipofacturacion = tipofacturacion;
    }
}