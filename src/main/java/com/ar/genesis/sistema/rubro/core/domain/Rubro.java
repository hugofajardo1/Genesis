package com.ar.genesis.sistema.rubro.core.domain;

import javax.persistence.*;

@Entity(name = "rubros")
@SequenceGenerator(name = "seq_rubros", sequenceName = "seq_rubros", allocationSize = 1)
public class Rubro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rubros")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;

    public Rubro() {
    }

    private Rubro(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static Rubro instancia(Integer id, String nombre){
        return new Rubro(id, nombre);
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