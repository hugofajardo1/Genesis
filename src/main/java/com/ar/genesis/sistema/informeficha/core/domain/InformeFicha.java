package com.ar.genesis.sistema.informeficha.core.domain;

import com.ar.genesis.sistema.ficha.core.domain.Ficha;
import com.ar.genesis.sistema.movimiento.core.domain.Movimiento;

import java.time.LocalDate;
import java.util.List;

public class InformeFicha {
    Ficha ficha;
    LocalDate fechaHasta;
    Double saldoInicial;
    Double saldoFinal;
    List<Movimiento> movimientos;

    public InformeFicha() {
    }

    public InformeFicha(Ficha ficha, LocalDate fechaHasta, Double saldoInicial, Double saldoFinal, List<Movimiento> movimientos) {
        this.ficha = ficha;
        this.fechaHasta = fechaHasta;
        this.saldoInicial = saldoInicial;
        this.saldoFinal = saldoFinal;
        this.movimientos = movimientos;
    }

    public static InformeFicha instancia(Ficha ficha, LocalDate fechaHasta, Double saldoInicial, Double saldoFinal, List<Movimiento> movimientos) {
        return new InformeFicha(ficha, fechaHasta, saldoInicial, saldoFinal, movimientos);
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
}
