package com.ar.genesis.sistema.core.domain;

import javax.persistence.*;

@Entity(name = "productos")
@SequenceGenerator(name = "seq_productos", sequenceName = "seq_productos", allocationSize = 1)
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_productos")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 110)
    String nombre;

    public Producto() {
    }

    private Producto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static Producto instancia(Integer id, String nombre){
        return new Producto(id, nombre);
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