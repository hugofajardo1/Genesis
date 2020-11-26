package com.ar.genesis.sistema.core.domain;

import javax.persistence.*;

@Entity(name = "tipo_movimientos")
@SequenceGenerator(name = "seq_tipo_movimientos", sequenceName = "seq_tipo_movimientos", allocationSize = 1)
public class TipoMovimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_movimientos")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;

    public TipoMovimiento() {
    }

    private TipoMovimiento(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static TipoMovimiento instancia(Integer id, String nombre){
        return new TipoMovimiento(id, nombre);
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