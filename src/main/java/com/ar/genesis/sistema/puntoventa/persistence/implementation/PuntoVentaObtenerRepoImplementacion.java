package com.ar.genesis.sistema.puntoventa.persistence.implementation;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.repository.IPuntoVentaObtenerRepository;
import com.ar.genesis.sistema.puntoventa.persistence.crud.IPuntoVentaCRUD;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PuntoVentaObtenerRepoImplementacion implements IPuntoVentaObtenerRepository {
    @Inject
    IPuntoVentaCRUD miPuntoVentaCRUD;

    @Override
    public List<PuntoVenta> obtenerPuntoVentas() {
        return miPuntoVentaCRUD.findAllByOrderById();
    }
}
