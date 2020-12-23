package com.ar.genesis.sistema.tipomovimiento.core.domain;

import javax.persistence.*;

@Entity(name = "tipo_movimientos")
@SequenceGenerator(name = "seq_tipo_movimientos", sequenceName = "seq_tipo_movimientos", allocationSize = 1)
public class TipoMovimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_movimientos")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;
    @Column(name = "imputacion", nullable = false, length = 5)
    String imputacion;

    public TipoMovimiento() {
    }

    private TipoMovimiento(Integer id, String nombre, String imputacion) {
        this.setId(id);
        this.setNombre(nombre);
        this.setImputacion(imputacion);
    }
    public static TipoMovimiento instancia(Integer id, String nombre, String imputacion){
        return new TipoMovimiento(id, nombre, imputacion);
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

    public String getImputacion() {
        return imputacion;
    }

    public void setImputacion(String imputacion) {
        this.imputacion = imputacion;
    }
}