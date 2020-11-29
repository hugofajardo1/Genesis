package com.ar.genesis.sistema.core.usecase;

import com.ar.genesis.sistema.core.domain.Ubicacion;
import com.ar.genesis.sistema.core.input.IObtenerUbicacionesInput;
import com.ar.genesis.sistema.core.repository.IObtenerUbicacionesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UbicacionObtenerUseCase implements IObtenerUbicacionesInput {

    IObtenerUbicacionesRepository miObtenerUbicacionesRepository;

    public UbicacionObtenerUseCase(IObtenerUbicacionesRepository miObtenerUbicacionesRepository) { this.miObtenerUbicacionesRepository = miObtenerUbicacionesRepository; }

    @Override
    public List<Ubicacion> obtenerUbicaciones() {
        return miObtenerUbicacionesRepository.obtenerUbicaciones();
    }
}
