package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.input.IUbicacionObtenerInput;
import com.ar.genesis.sistema.core.repository.IUbicacionObtenerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UbicacionObtenerUseCase implements IUbicacionObtenerInput {

    IUbicacionObtenerRepository miUbicacionObtenerRepository;

    public UbicacionObtenerUseCase(IUbicacionObtenerRepository miUbicacionObtenerRepository) { this.miUbicacionObtenerRepository = miUbicacionObtenerRepository; }

    @Override
    public List<Ubicacion> obtenerUbicaciones() {
        return miUbicacionObtenerRepository.obtenerUbicaciones();
    }
}
