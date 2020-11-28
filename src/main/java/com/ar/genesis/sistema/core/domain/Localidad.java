package com.ar.genesis.sistema.core.domain;

import javax.persistence.*;

@Entity(name = "localidades")
@SequenceGenerator(name = "seq_localidades", sequenceName = "seq_localidades", allocationSize = 1)
public class Localidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_localidades")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;

    public Localidad() {
    }

    private Localidad(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static Localidad instancia(Integer id, String nombre){
        return new Localidad(id, nombre);
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