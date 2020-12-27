package com.ar.genesis.sistema.tipomovimiento.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TipoMovimientoDTO {
    @JsonProperty("id")
    Integer id;
    @JsonProperty("nombre")
    String nombre;
    @JsonProperty("imputacion")
    String imputacion;

    public TipoMovimientoDTO(){

    }

    public TipoMovimientoDTO(Integer id, String nombre, String imputacion) {
        this.setId(id);
        this.setNombre(nombre);
        this.setImputacion(imputacion);
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

    public String getImputacion() {
        return imputacion;
    }

    public void setImputacion(String imputacion) {
        this.imputacion = imputacion;
    }
}