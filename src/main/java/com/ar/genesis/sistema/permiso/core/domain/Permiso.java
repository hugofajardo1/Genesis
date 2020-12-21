package com.ar.genesis.sistema.permiso.core.domain;

import javax.persistence.*;

@Entity(name = "permisos")
@SequenceGenerator(name = "seq_permisos", sequenceName = "seq_permisos", allocationSize = 1)
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_permisos")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;

    public Permiso() {
    }

    private Permiso(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static Permiso instancia(Integer id, String nombre){
        return new Permiso(id, nombre);
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