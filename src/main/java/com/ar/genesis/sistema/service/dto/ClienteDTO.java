package com.ar.genesis.sistema.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteDTO {

    @JsonProperty("id")
    Integer id;
    @JsonProperty("nombre")
    String nombre;
    @JsonProperty("domicilio")
    String domicilio;
    @JsonProperty("telefono")
    String telefono;
    @JsonProperty("tipo_iva")
    TipoIvaDTO tipoIva;
    @JsonProperty("cuit")
    String cuit;

    public ClienteDTO(Integer id, String nombre, String domicilio, String telefono, TipoIvaDTO tipoIva, String cuit) {
        this.setId(id);
        this.setNombre(nombre);
        this.setDomicilio(domicilio);
        this.setTelefono(telefono);
        this.setTipoIva(tipoIva);
        this.setCuit(cuit);
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
}