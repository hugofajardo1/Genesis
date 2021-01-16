package com.ar.genesis.sistema.informeficha.service.dto;

import com.ar.genesis.sistema.ficha.service.dto.FichaDTO;
import com.ar.genesis.sistema.movimiento.service.dto.MovimientoDTO;

import java.time.LocalDate;
import java.util.List;

public class InformeFichaDTO {
    FichaDTO ficha;
    LocalDate fechaDesde;
    LocalDate fechaHasta;
    Double saldoInicial;
    Double saldoFinal;
    List<MovimientoDTO> movimientos;

    public InformeFichaDTO() {
    }

    public InformeFichaDTO(FichaDTO ficha, LocalDate fechaDesde, LocalDate fechaHasta, Double saldoInicial, Double saldoFinal, List<MovimientoDTO> movimientos) {
        this.ficha = ficha;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.saldoInicial = saldoInicial;
        this.saldoFinal = saldoFinal;
        this.movimientos = movimientos;
    }

    public FichaDTO getFicha() {
        return ficha;
    }

    public void setFicha(FichaDTO ficha) {
        this.ficha = ficha;
    }

    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
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

    public List<MovimientoDTO> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientoDTO> movimientos) {
        this.movimientos = movimientos;
    }
}
