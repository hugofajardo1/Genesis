package com.ar.genesis.sistema.tipooperacion.core.domain;

import javax.persistence.*;

@Entity(name = "tipo_operaciones")
@SequenceGenerator(name = "seq_tipo_operaciones", sequenceName = "seq_tipo_operaciones", allocationSize = 1)
public class TipoOperacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_operaciones")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;

    public TipoOperacion() {
    }

    public TipoOperacion(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static TipoOperacion instancia(Integer id, String nombre){
        return new TipoOperacion(id, nombre);
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