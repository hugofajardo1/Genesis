package com.ar.genesis.sistema.producto.service.dto;

import com.ar.genesis.sistema.proveedor.service.dto.ProveedorDTO;
import com.ar.genesis.sistema.rubro.service.dto.RubroDTO;
import com.ar.genesis.sistema.subrubro.service.dto.SubRubroDTO;
import com.ar.genesis.sistema.tipounidad.service.dto.TipoUnidadDTO;
import com.ar.genesis.sistema.ubicacion.service.dto.UbicacionDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductoDTO {

    @JsonProperty("id")
    Integer id;
    @JsonProperty("nombre")
    String nombre;
    @JsonProperty("codigousuario")
    String codigoUsuario;
    @JsonProperty("codigobarra")
    String codigoBarra;
    @JsonProperty("tipounidad")
    TipoUnidadDTO tipoUnidad;
    @JsonProperty("costo")
    Double costo;
    @JsonProperty("iva")
    Double iva;
    @JsonProperty("margen")
    Double margen;
    @JsonProperty("flete")
    Double flete;
    @JsonProperty("rubro")
    RubroDTO rubro;
    @JsonProperty("subrubro")
    SubRubroDTO subRubro;
    @JsonProperty("ubicacion")
    UbicacionDTO ubicacion;
    @JsonProperty("proveedor")
    ProveedorDTO proveedor;
    @JsonProperty("precioventa")
    Double precioVenta;

    public ProductoDTO(){

    }

    public ProductoDTO(Integer id, String nombre, String codigoUsuario, String codigoBarra, TipoUnidadDTO tipoUnidad, Double costo, Double iva, Double margen, Double flete, RubroDTO rubro, SubRubroDTO subRubro, UbicacionDTO ubicacion, ProveedorDTO proveedor) {
        this.setId(id);
        this.setNombre(nombre);
        this.setCodigoUsuario(codigoUsuario);
        this.setCodigoBarra(codigoBarra);
        this.setTipoUnidad(tipoUnidad);
        this.setCosto(costo);
        this.setIva(iva);
        this.setMargen(margen);
        this.setFlete(flete);
        this.setRubro(rubro);
        this.setSubRubro(subRubro);
        this.setUbicacion(ubicacion);
        this.setProveedor(proveedor);
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

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public TipoUnidadDTO getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(TipoUnidadDTO tipoUnidad) {
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

    public RubroDTO getRubro() {
        return rubro;
    }

    public void setRubro(RubroDTO rubro) {
        this.rubro = rubro;
    }

    public SubRubroDTO getSubRubro() {
        return subRubro;
    }

    public void setSubRubro(SubRubroDTO subRubro) {
        this.subRubro = subRubro;
    }

    public UbicacionDTO getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionDTO ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ProveedorDTO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorDTO proveedor) {
        this.proveedor = proveedor;
    }

    public Double getPrecioVenta() {
        double precioCalculado = this.getCosto() * ((this.getFlete() /100)+1) * ((this.getMargen() /100)+1) * ((this.getIva() /100)+1);
        return Math.round(precioCalculado * 100.0) / 100.0;
    }
}