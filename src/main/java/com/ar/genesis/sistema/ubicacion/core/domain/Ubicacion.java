package com.ar.genesis.sistema.ubicacion.core.domain;

import javax.persistence.*;

@Entity(name = "ubicaciones")
@SequenceGenerator(name = "seq_ubicaciones", sequenceName = "seq_ubicaciones", allocationSize = 1)
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ubicaciones")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;

    public Ubicacion() {
    }

    private Ubicacion(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static Ubicacion instancia(Integer id, String nombre){
        return new Ubicacion(id, nombre);
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