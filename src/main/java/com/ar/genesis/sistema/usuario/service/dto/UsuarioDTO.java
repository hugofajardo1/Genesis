package com.ar.genesis.sistema.usuario.service.dto;

import com.ar.genesis.sistema.sucursal.service.dto.SucursalDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioDTO {
    @JsonProperty("id")
    Integer id;
    @JsonProperty("nombre")
    String nombre;
    @JsonProperty("nombreusuario")
    String nombreUsuario;
    @JsonProperty("contrasenia")
    String contrasenia;
    @JsonProperty("sucursal")
    SucursalDTO sucursal;

    public UsuarioDTO(){

    }

    public UsuarioDTO(Integer id, String nombre, String nombreUsuario, String contrasenia, SucursalDTO sucursalDTO) {
        this.setId(id);
        this.setNombre(nombre);
        this.setNombreUsuario(nombreUsuario);
        this.setContrasenia(contrasenia);
        this.setSucursal(sucursalDTO);
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }
}