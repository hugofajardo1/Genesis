package com.ar.genesis.sistema.vendedor.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VendedorDTO {
    @JsonProperty("id")
    Integer id;
    @JsonProperty("nombre")
    String nombre;

    public VendedorDTO(){

    }

    public VendedorDTO(Integer id, String nombre) {
        this.setId(id);
        this.setNombre(nombre);
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

}