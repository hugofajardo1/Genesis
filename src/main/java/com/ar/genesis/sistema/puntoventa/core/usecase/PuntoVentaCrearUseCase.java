package com.ar.genesis.sistema.puntoventa.core.usecase;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.exception.PuntoVentaExisteException;
import com.ar.genesis.sistema.puntoventa.core.input.IPuntoVentaCrearInput;
import com.ar.genesis.sistema.puntoventa.core.repository.IPuntoVentaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PuntoVentaCrearUseCase implements IPuntoVentaCrearInput {

    IPuntoVentaRepository miPuntoVentaRepository;

    public PuntoVentaCrearUseCase(IPuntoVentaRepository miPuntoVentaRepository) {
        this.miPuntoVentaRepository = miPuntoVentaRepository;
    }

    @Override
    public boolean crearPuntoVenta(PuntoVenta unPuntoVenta) throws PuntoVentaExisteException {
        if(miPuntoVentaRepository.existePuntoVenta(unPuntoVenta.getNombre())){
            throw new PuntoVentaExisteException();
        }
        return miPuntoVentaRepository.guardarPuntoVenta(unPuntoVenta);
    }
}
