package com.ar.genesis.sistema.core.domain;

import javax.persistence.*;

@Entity(name = "puntosventas")
@SequenceGenerator(name = "seq_puntosventas", sequenceName = "seq_puntosventas", allocationSize = 1)
public class PuntoVenta {
    @Id
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;
    @Column(name = "tipofacturacion", nullable = false)
    Integer tipoFacturacion;

    public PuntoVenta() {
    }

    private PuntoVenta(Integer id, String nombre, Integer tipoFacturacion) {
        this.setId(id);
        this.setNombre(nombre);
        this.setTipoFacturacion(tipoFacturacion);
    }
    public static PuntoVenta instancia(Integer id, String nombre, Integer tipoFacturacion){
        return new PuntoVenta(id, nombre, tipoFacturacion);
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

    public Integer getTipoFacturacion() {
        return tipoFacturacion;
    }

    public void setTipoFacturacion(Integer tipoFacturacion) {
        this.tipoFacturacion = tipoFacturacion;
    }
}