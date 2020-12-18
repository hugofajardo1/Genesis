package com.ar.genesis.sistema.puntoventa.core.usecase;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.exception.PuntoVentaNoExisteException;
import com.ar.genesis.sistema.puntoventa.core.input.IPuntoVentaObtenerPorIdInput;
import com.ar.genesis.sistema.puntoventa.core.repository.IPuntoVentaObtenerPorIdRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PuntoVentaObtenerPorIdUseCase implements IPuntoVentaObtenerPorIdInput {

    IPuntoVentaObtenerPorIdRepository miPuntoVentaObtenerPorIdRepository;

    public PuntoVentaObtenerPorIdUseCase(IPuntoVentaObtenerPorIdRepository miPuntoVentaObtenerPorIdRepository) { this.miPuntoVentaObtenerPorIdRepository = miPuntoVentaObtenerPorIdRepository; }

    @Override
    public PuntoVenta obtenerPuntoVenta(Integer id) throws PuntoVentaNoExisteException {
        PuntoVenta unPuntoVenta = miPuntoVentaObtenerPorIdRepository.obtenerPuntoVenta(id);
        if(unPuntoVenta==null){
            throw new PuntoVentaNoExisteException();
        }
        return unPuntoVenta;
    }
}
