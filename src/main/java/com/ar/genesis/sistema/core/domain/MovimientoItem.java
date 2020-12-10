package com.ar.genesis.sistema.core.domain;

import javax.persistence.*;

@Entity(name = "movimientositem")
@SequenceGenerator(name = "seq_movimientositem", sequenceName = "seq_movimientositem", allocationSize = 1)
public class MovimientoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_movimientos")
    Integer id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "productoid")
    Producto producto;
    @Column(name = "cantidad", nullable = false)
    Double cantidad;
    @Column(name = "iva", nullable = false)
    Double iva;
    @Column(name = "preciocosto", nullable = false)
    Double precioCosto;
    @Column(name = "precioventa", nullable = false)
    Double precioVenta;
    @Column(name = "precioventafinal", nullable = false)
    Double precioVentaFinal;

    public MovimientoItem() {
    }

    private MovimientoItem(Integer id, Producto producto, Double cantidad, Double iva, Double precioCosto, Double precioVenta, Double precioVentaFinal) {
        this.setId(id);
        this.setProducto(producto);
        this.setCantidad(cantidad);
        this.setIva(iva);
        this.setPrecioCosto(precioCosto);
        this.setPrecioVenta(precioVenta);
        this.setPrecioVentaFinal(precioVentaFinal);
    }

    public static MovimientoItem instancia(Integer id, Producto producto, Double cantidad, Double iva, Double precioCosto, Double precioVenta, Double precioVentaFinal) {
        return new MovimientoItem(id, producto, cantidad, iva, precioCosto, precioVenta, precioVentaFinal);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getPrecioVentaFinal() {
        return precioVentaFinal;
    }

    public void setPrecioVentaFinal(Double precioVentaFinal) {
        this.precioVentaFinal = precioVentaFinal;
    }
}
