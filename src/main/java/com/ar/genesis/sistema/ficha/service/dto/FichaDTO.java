package com.ar.genesis.sistema.ficha.service.dto;

import com.ar.genesis.sistema.localidad.service.dto.LocalidadDTO;
import com.ar.genesis.sistema.provincia.service.dto.ProvinciaDTO;
import com.ar.genesis.sistema.tipoiva.service.dto.TipoIvaDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FichaDTO {

    @JsonProperty("id")
    Integer id;
    @JsonProperty("nombre")
    String nombre;
    @JsonProperty("domicilio")
    String domicilio;
    @JsonProperty("localidad")
    LocalidadDTO localidad;
    @JsonProperty("provincia")
    ProvinciaDTO provincia;
    @JsonProperty("telefono")
    String telefono;
    @JsonProperty("tipo_iva")
    TipoIvaDTO tipoIva;
    @JsonProperty("cuit")
    String cuit;
    @JsonProperty("ibrutos")
    String ibrutos;
    @JsonProperty("contacto")
    String contacto;

    public FichaDTO(){

    }

    public FichaDTO(Integer id, String nombre, String domicilio, LocalidadDTO localidad, ProvinciaDTO provincia, String telefono, TipoIvaDTO tipoIva, String cuit, String ibrutos, String contacto) {
        this.setId(id);
        this.setNombre(nombre);
        this.setDomicilio(domicilio);
        this.setLocalidad(localidad);
        this.setProvincia(provincia);
        this.setTelefono(telefono);
        this.setTipoIva(tipoIva);
        this.setCuit(cuit);
        this.setIbrutos(ibrutos);
        this.setContacto(contacto);
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

    public LocalidadDTO getLocalidad() {
        return localidad;
    }

    public void setLocalidad(LocalidadDTO localidad) {
        this.localidad = localidad;
    }

    public ProvinciaDTO getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaDTO provincia) {
        this.provincia = provincia;
    }

    public String getIbrutos() {
        return ibrutos;
    }

    public void setIbrutos(String ibrutos) {
        this.ibrutos = ibrutos;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}