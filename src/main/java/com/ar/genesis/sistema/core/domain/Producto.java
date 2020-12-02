package com.ar.genesis.sistema.core.domain;

import javax.persistence.*;

@Entity(name = "productos")
@SequenceGenerator(name = "seq_productos", sequenceName = "seq_productos", allocationSize = 1)
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_productos")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 110)
    String nombre;
    @Column(name = "codigousuario", nullable = false, length = 110)
    String codigoUsuario;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tipounidadid")
    TipoUnidad tipoUnidad;
    @Column(name = "costo", nullable = false)
    Double costo;
    @Column(name = "iva", nullable = false)
    Double iva;
    @Column(name = "margen", nullable = false)
    Double margen;
    @Column(name = "flete", nullable = false)
    Double flete;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "rubroid")
    Rubro rubro;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "subrubroid")
    SubRubro subRubro;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ubicacionid")
    Ubicacion ubicacion;

    public Producto() {
    }

    private Producto(Integer id, String nombre, String codigoUsuario, TipoUnidad unidad, double costo, double iva, double margen, double flete, Rubro rubro, SubRubro subRubro, Ubicacion ubicacion) {
        this.setId(id);
        this.setNombre(nombre);
        this.setCodigoUsuario(codigoUsuario);
        this.setTipoUnidad(unidad);
        this.setCosto(costo);
        this.setIva(iva);
        this.setMargen(margen);
        this.setFlete(flete);
        this.setRubro(rubro);
        this.setSubRubro(subRubro);
        this.setUbicacion(ubicacion);
    }

    public static Producto instancia(Integer id, String nombre, String codigoUsuario, TipoUnidad unidad, double costo, double iva, double margen, double flete, Rubro rubro, SubRubro subRubro, Ubicacion ubicacion){
        return new Producto(id, nombre, codigoUsuario, unidad, costo, iva, margen, flete, rubro, subRubro, ubicacion);
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

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public TipoUnidad getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(TipoUnidad tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getMargen() {
        return margen;
    }

    public void setMargen(Double margen) {
        this.margen = margen;
    }

    public Double getFlete() {
        return flete;
    }

    public void setFlete(Double flete) {
        this.flete = flete;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public SubRubro getSubRubro() {
        return subRubro;
    }

    public void setSubRubro(SubRubro subRubro) {
        this.subRubro = subRubro;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}