package com.ar.genesis.sistema.core.domain;

import javax.persistence.*;

@Entity(name = "tipo_unidades")
@SequenceGenerator(name = "seq_tipo_unidades", sequenceName = "seq_tipo_unidades", allocationSize = 1)
public class TipoUnidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_unidades")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 100)
    String nombre;

    public TipoUnidad() {
    }

    public TipoUnidad(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static TipoUnidad instancia(Integer id, String nombre){
        return new TipoUnidad(id, nombre);
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