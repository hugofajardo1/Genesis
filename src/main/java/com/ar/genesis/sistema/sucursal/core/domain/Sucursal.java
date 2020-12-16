package com.ar.genesis.sistema.sucursal.core.domain;

import javax.persistence.*;

@Entity(name = "sucursales")
@SequenceGenerator(name = "seq_sucursales", sequenceName = "seq_sucursales", allocationSize = 1)
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sucursales")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;

    public Sucursal() {
    }

    private Sucursal(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static Sucursal instancia(Integer id, String nombre){
        return new Sucursal(id, nombre);
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