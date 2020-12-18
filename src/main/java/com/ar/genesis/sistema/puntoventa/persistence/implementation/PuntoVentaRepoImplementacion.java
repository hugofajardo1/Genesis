package com.ar.genesis.sistema.puntoventa.persistence.implementation;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.repository.IPuntoVentaRepository;
import com.ar.genesis.sistema.puntoventa.persistence.crud.IPuntoVentaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class PuntoVentaRepoImplementacion implements IPuntoVentaRepository {

    @Inject
    IPuntoVentaCRUD miPuntoVentaCRUD;

    @Override
    public boolean existePuntoVenta(String nombre) { return miPuntoVentaCRUD.existsByNombre(nombre); }

    @Override
    public boolean guardarPuntoVenta(PuntoVenta unPuntoVenta) { return miPuntoVentaCRUD.save(unPuntoVenta).getId()!=null; }
}
