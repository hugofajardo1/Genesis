package com.ar.genesis.sistema.puntoventa.core.domain;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;

import javax.persistence.*;

@Entity(name = "puntosventas")
@SequenceGenerator(name = "seq_puntosventas", sequenceName = "seq_puntosventas", allocationSize = 1)
public class PuntoVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_puntosventas")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sucursalid")
    Sucursal sucursal;
    @Column(name = "tipofacturacion", nullable = false)
    Integer tipoFacturacion;

    public PuntoVenta() {
    }

    private PuntoVenta(Integer id, String nombre, Sucursal sucursal, Integer tipoFacturacion) {
        this.setId(id);
        this.setNombre(nombre);
        this.setSucursal(sucursal);
        this.setTipoFacturacion(tipoFacturacion);
    }
    public static PuntoVenta instancia(Integer id, String nombre, Sucursal sucursal, Integer tipoFacturacion){
        return new PuntoVenta(id, nombre, sucursal, tipoFacturacion);
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

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getTipoFacturacion() {
        return tipoFacturacion;
    }

    public void setTipoFacturacion(Integer tipoFacturacion) {
        this.tipoFacturacion = tipoFacturacion;
    }
}