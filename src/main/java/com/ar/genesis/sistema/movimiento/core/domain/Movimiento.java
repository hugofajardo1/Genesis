package com.ar.genesis.sistema.movimiento.core.domain;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;
import com.ar.genesis.sistema.tipoiva.core.domain.TipoIva;
import com.ar.genesis.sistema.tipomovimiento.core.domain.TipoMovimiento;
import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.tipooperacion.core.domain.TipoOperacion;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "movimientos")
@SequenceGenerator(name = "seq_movimientos", sequenceName = "seq_movimientos", allocationSize = 1)
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_movimientos")
    Integer id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sucursalid")
    Sucursal sucursal;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "puntoventaid")
    PuntoVenta puntoVenta;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tipooperacionid")
    TipoOperacion tipoOperacion;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tipomovimientoid")
    TipoMovimiento tipoMovimiento;
    @Column(name = "numero", nullable = false)
    Integer numero;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fichaid")
    Ficha ficha;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tipoivaid")
    TipoIva tipoIva;
    @Column(name = "cuit", nullable = false, length = 11)
    String cuit;
    @Column(name = "fecha", nullable = false)
    LocalDate fecha;
    @Column(name = "hora", nullable = false)
    LocalTime hora;
    @Column(name = "montoneto", nullable = false)
    Double montoNeto;
    @Column(name = "montototal", nullable = false)
    Double montoTotal;
    @Column(name = "saldo", nullable = false)
    Double saldo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "movimientoid")
    private List<MovimientoItem> items;

    public Movimiento() {
    }

    private Movimiento(Integer id, PuntoVenta puntoVenta, TipoOperacion tipoOperacion, TipoMovimiento tipoMovimiento, Integer numero, Ficha ficha, TipoIva tipoIva, String cuit, LocalDate fecha, LocalTime hora, Double montoNeto, Double montoTotal, Double saldo) {
        this.setId(id);
        this.setSucursal(puntoVenta.getSucursal());
        this.setPuntoVenta(puntoVenta);
        this.setTipoOperacion(tipoOperacion);
        this.setTipoMovimiento(tipoMovimiento);
        this.setNumero(numero);
        this.setFicha(ficha);
        this.setTipoIva(tipoIva);
        this.setCuit(cuit);
        this.setFecha(fecha);
        this.setHora(hora);
        this.setMontoNeto(montoNeto);
        this.setMontoTotal(montoTotal);
        this.setSaldo(saldo);
        this.setItems(new ArrayList<>());
    }

    public static Movimiento instanciaProveedor(Integer id, PuntoVenta puntoVenta, TipoMovimiento tipoMovimiento, Integer numero, Ficha ficha, TipoIva tipoIva, String cuit, LocalDate fecha, LocalTime hora, Double montoNeto, Double montoTotal, Double saldo) {
        return new Movimiento(id, puntoVenta, TipoOperacion.instancia(2, "Compra"), tipoMovimiento, numero, ficha, tipoIva, cuit, fecha, hora, montoNeto, montoTotal, saldo);
    }

    public static Movimiento instanciaCliente(Integer id, PuntoVenta puntoVenta, TipoMovimiento tipoMovimiento, Ficha ficha, TipoIva tipoIva, String cuit, LocalDate fecha, LocalTime hora, Double montoNeto, Double montoTotal, Double saldo) {
        return new Movimiento(id, puntoVenta, TipoOperacion.instancia(1, "Venta"), tipoMovimiento, 0, ficha, tipoIva, cuit, fecha, hora, montoNeto, montoTotal, saldo);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public PuntoVenta getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(PuntoVenta puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public TipoIva getTipoIva() {
        return tipoIva;
    }

    public void setTipoIva(TipoIva tipoIva) {
        this.tipoIva = tipoIva;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Double getMontoNeto() {
        return montoNeto;
    }

    public void setMontoNeto(Double montoNeto) {
        this.montoNeto = montoNeto;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<MovimientoItem> getItems() {
        return items;
    }

    public void setItems(List<MovimientoItem> movimientos) {
        this.items = movimientos;
    }

    public Double MontoTotalImputado(){
        if (this.getTipoMovimiento().getImputacion().equals("Debe")) {
            return this.getMontoTotal();
        } else {
            return -this.getMontoTotal();
        }
    }
}