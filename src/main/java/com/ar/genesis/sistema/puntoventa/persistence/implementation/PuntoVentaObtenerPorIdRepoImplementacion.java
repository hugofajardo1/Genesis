package com.ar.genesis.sistema.puntoventa.persistence.implementation;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.repository.IPuntoVentaObtenerPorIdRepository;
import com.ar.genesis.sistema.puntoventa.persistence.crud.IPuntoVentaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class PuntoVentaObtenerPorIdRepoImplementacion implements IPuntoVentaObtenerPorIdRepository {
    @Inject
    IPuntoVentaCRUD miPuntoVentaCRUD;

    @Override
    public PuntoVenta obtenerPuntoVenta(Integer id) { return miPuntoVentaCRUD.findPuntoVentaByIdEquals(id); }
}
