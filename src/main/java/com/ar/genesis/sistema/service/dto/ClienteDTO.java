package com.ar.genesis.sistema.service.dto;

import com.ar.genesis.sistema.core.domain.Cliente;

public class ClienteDTO {

    Integer id;
    String nombre;
    String domicilio;
    String telefono;

    private ClienteDTO(Cliente unCliente) {
        this.setId(unCliente.getId());
        this.setNombre(unCliente.getNombre());
        this.setDomicilio(unCliente.getDomicilio());
        this.setTelefono(unCliente.getTelefono());
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
}