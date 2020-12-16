package com.ar.genesis.sistema.movimiento.service.dto;

import com.ar.genesis.sistema.producto.service.dto.ProductoDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovimientoItemDTO {
    @JsonProperty("id")
    Integer id;
    @JsonProperty("producto")
    ProductoDTO producto;
    @JsonProperty("cantidad")
    Double cantidad;
    @JsonProperty("iva")
    Double iva;
    @JsonProperty("preciocosto")
    Double precioCosto;
    @JsonProperty("precioventa")
    Double precioVenta;
    @JsonProperty("precioventafinal")
    Double precioVentaFinal;

    public MovimientoItemDTO(Integer id, ProductoDTO producto, Double cantidad, Double iva, Double precioCosto, Double precioVenta, Double precioVentaFinal) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.iva = iva;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.precioVentaFinal = precioVentaFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
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
