package com.ar.genesis.sistema.provincia.core.domain;

import javax.persistence.*;

@Entity(name = "provincias")
@SequenceGenerator(name = "seq_provincias", sequenceName = "seq_provincias", allocationSize = 1)
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_provincias")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;

    public Provincia() {
    }

    private Provincia(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static Provincia instancia(Integer id, String nombre){
        return new Provincia(id, nombre);
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