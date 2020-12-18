package com.ar.genesis.sistema.puntoventa.core.usecase;

import com.ar.genesis.sistema.puntoventa.core.domain.PuntoVenta;
import com.ar.genesis.sistema.puntoventa.core.input.IPuntoVentaObtenerInput;
import com.ar.genesis.sistema.puntoventa.core.repository.IPuntoVentaObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PuntoVentaObtenerUseCase implements IPuntoVentaObtenerInput {

    IPuntoVentaObtenerRepository miPuntoVentaObtenerRepository;

    public PuntoVentaObtenerUseCase(IPuntoVentaObtenerRepository miPuntoVentaObtenerRepository) { this.miPuntoVentaObtenerRepository = miPuntoVentaObtenerRepository; }

    @Override
    public List<PuntoVenta> obtenerPuntoVentas() {
        return miPuntoVentaObtenerRepository.obtenerPuntoVentas();
    }
}
