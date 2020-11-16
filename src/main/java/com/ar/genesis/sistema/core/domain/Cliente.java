package com.ar.genesis.sistema.core.domain;

import javax.persistence.*;

@Entity(name = "clientes")
@SequenceGenerator(name = "seq_clientes", sequenceName = "seq_clientes", allocationSize = 1)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_clientes")
    Integer id;
    String nombre;
    String domicilio;
    String telefono;

    public Cliente() {
    }

    private Cliente(Integer id, String nombre, String domicilio, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }
    public static Cliente instancia(Integer id, String nombre, String domicilio, String telefono){
        return new Cliente(id, nombre, domicilio, telefono);
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
